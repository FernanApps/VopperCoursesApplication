package presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import domain.model.Chapter
import koinViewModel
import org.jetbrains.compose.resources.stringResource
import presentation.screens.CoursesViewModel
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.chapter
import voppercourses.composeapp.generated.resources.chapters
import voppercourses.composeapp.generated.resources.hello

@Composable
fun CourseDetailsView(
    keyCourse: String,
    onBack: () -> Unit,
    viewModel: CoursesViewModel = koinViewModel()
) {
    val chapters by viewModel.chapters.collectAsState()
    val course by viewModel.currentCourse.collectAsState()
    viewModel.setCurrentCourse(keyCourse)


    LaunchedEffect(true) {
        viewModel.getChapters()
    }
    Column(
        modifier = Modifier
            .fillMaxSize().padding(20.dp),
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = {
            onBack()
        }) {
            Icon(imageVector = Icons.Filled.ArrowBackIosNew, "ArrowBackIosNew")
        }
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
            LazyColumn {
                items(chapters) {
                    ChapterItem(chapter = it) {

                    }
                }
            }
        }
    }
}


@Composable
fun ChapterItem(modifier: Modifier = Modifier, chapter: Chapter, onClick: (Chapter) -> Unit) {
    Card(modifier = modifier.fillMaxWidth(), onClick = {
        onClick(chapter)
    }) {
        Text(
            text = stringResource(Res.string.chapter) + " [ " + chapter.index + " ] ",
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
        )
    }
}