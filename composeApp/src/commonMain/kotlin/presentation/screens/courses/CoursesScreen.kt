package presentation.screens.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import domain.model.Course
import koinViewModel
import org.jetbrains.compose.resources.stringResource
import presentation.screens.CoursesViewModel
import presentation.theme.LocalWindowSizeWidth
import presentation.theme.WindowSize
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.category
import voppercourses.composeapp.generated.resources.hello

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(onNavigate: (keyCourse: String) -> Unit, viewModel: CoursesViewModel) {

    val userName by viewModel.userName.collectAsState()
    val courses by viewModel.courses.collectAsState()
    val searchText by viewModel.searchText.collectAsState()

    LaunchedEffect(true){
        viewModel.getUserName()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(Res.string.hello), style = MaterialTheme.typography.titleSmall)
        Text(
            userName,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )


        val primaryColor = MaterialTheme.colorScheme.primary
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                viewModel.onSearchTextChanged(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                Icon(Icons.Filled.Add, "", tint = primaryColor)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                //focusedIndicatorColor = Color.Transparent,
                //unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(Modifier.size(5.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            Text(stringResource(Res.string.category) + ":", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.size(5.dp))
            listOf("CSS","UX","Swift", "Kotlin").map { "#$it" }.forEach {
                Card(
                    onClick = {

                    },
                    modifier = Modifier.padding(end = 5.dp),
                    colors = CardDefaults.cardColors(
                    containerColor = primaryColor,
                )){
                    Text(it, modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp), style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.background)
                    Spacer(Modifier.width(5.dp))
                }
            }

        }
        Spacer(Modifier.size(5.dp))

        if (LocalWindowSizeWidth.current == WindowSize.Compact) {
            LazyColumn {
                items(courses) {
                    CourseItem(modifier = Modifier.padding(bottom = 10.dp), course = it, onNavigate)
                }
            }
        } else {
            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
                items(courses) {
                    CourseItem(
                        modifier = Modifier.padding(end = 10.dp, bottom = 10.dp),
                        course = it,
                        onNavigate
                    )
                }
            }
        }
    }
}

@Composable
fun CourseItem(modifier: Modifier = Modifier, course: Course, onClick: (String) -> Unit) {
    OutlinedCard(modifier = modifier.fillMaxWidth(), onClick = { onClick(course.key) }) {
        Column {
            val painter = rememberImagePainter(course.image)
            Image(
                modifier = Modifier.fillMaxWidth().height(180.dp),
                painter = painter,
                contentDescription = course.title,
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(20.dp)) {
                Text(course.title, style = MaterialTheme.typography.titleSmall)

            }

        }
    }

}