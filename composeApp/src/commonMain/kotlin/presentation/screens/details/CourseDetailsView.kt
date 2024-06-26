package presentation.screens.details

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.lighten
import data.local.directoryPath
import domain.model.Chapter
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.skiko.hostOs
import presentation.components.IconButtonBack
import presentation.screens.CoursesViewModel
import utils.PathUtils
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.chapter
import voppercourses.composeapp.generated.resources.chapters
import voppercourses.composeapp.generated.resources.soon

@Composable
fun CourseDetailsView(
    keyCourse: String,
    onBack: () -> Unit,
    navigateToPlayer: (videoUrl: String, videoTitle: String) -> Unit,
    viewModel: CoursesViewModel
) {
    val chapters by viewModel.chapters.collectAsState()
    val course by viewModel.currentCourse.collectAsState()


    LaunchedEffect(true) {
        viewModel.setCurrentCourse(keyCourse)
        viewModel.getChapters()
        //viewModel.updateChapterWithPercentage()

    }

    Column(
        modifier = Modifier
            .fillMaxSize().padding(20.dp),
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        IconButtonBack(onBack = onBack)
        Spacer(Modifier.size(10.dp))
        Text(
            if (chapters.isEmpty()) "" else stringResource(Res.string.chapters) + " : ${chapters.size}",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            course?.title ?: "",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )

        if (chapters.isEmpty()) {
            CircularProgressIndicator()
        } else {
            println("XXXX Updater ,,,,,,")

            LazyColumn {
                items(chapters, key = {
                    keyCourse + it.index + it.percentageWatched
                }) {
                    ChapterItem(
                        modifier = Modifier.padding(bottom = 5.dp),
                        chapter = it,
                    ) { chapter ->
                        val nameChapter = viewModel.createNameChapter(
                            title = course!!.title,
                            index = chapter.index
                        )
                        navigateToPlayer(chapter.link, nameChapter)
                    }
                }
            }
        }
    }
}


@Composable
fun ChapterItem(modifier: Modifier = Modifier, chapter: Chapter, onClick: (Chapter) -> Unit) {

    var progress by remember { mutableStateOf(0f) }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(true) {
        if (chapter.percentageWatched > 0) {
            progress = chapter.progress
        }
    }


    Column {

        /*LinearProgressIndicator(
            progress = { progress }, modifier = Modifier.fillMaxWidth(),
        )*/

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = modifier.fillMaxWidth()
                    .height(if (chapter.percentageWatched > 0) 180.dp else 50.dp), onClick = {
                    if (!chapter.soon) onClick(chapter)
                }) {
                Box(Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(size)
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.30f))
                            .animateContentSize()
                    )
                    Column {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(Res.string.chapter) + " [ " + chapter.index + " ] ",
                                modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
                                    .weight(1f)
                            )
                            if (chapter.soon) {
                                Card(
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primary.lighten(),
                                        contentColor = MaterialTheme.colorScheme.background
                                    )
                                ) {
                                    Text(
                                        stringResource(Res.string.soon),
                                        modifier = Modifier.padding(
                                            horizontal = 8.dp,
                                            vertical = 4.dp
                                        )
                                    )
                                }
                                Spacer(Modifier.size(5.dp))

                            }

                        }
                        if (chapter.percentageWatched > 0) {
                            Card(
                                modifier = Modifier.width(180.dp).fillMaxHeight().padding(start = 10.dp, bottom = 10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                            ) {
                                if (hostOs.isWindows) {
                                    presentation.components.shared.AsyncImage(
                                        modifier = Modifier.fillMaxSize(),
                                        model = directoryPath + chapter.thumbnail,
                                        contentDescription = "chapter index ${chapter.index}",
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.TopCenter,
                                        alpha = DefaultAlpha,
                                        colorFilter = null
                                    )

                                } else {
                                    coil3.compose.AsyncImage(
                                        modifier = Modifier.fillMaxSize(),
                                        model = PathUtils.fixImagePath(directoryPath + chapter.thumbnail),
                                        contentDescription = "chapter index ${chapter.index}",
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.TopCenter,
                                        alpha = DefaultAlpha,
                                        colorFilter = null
                                    )
                                }

                            }

                        }

                    }



                }

            }


        }
    }

}