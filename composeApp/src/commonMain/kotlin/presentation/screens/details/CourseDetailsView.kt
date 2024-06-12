package presentation.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.Course
import koinViewModel
import presentation.screens.CoursesViewModel
import utils.toJson

@Composable
fun CourseDetailsView(course: Course, onNavigate: () -> Unit,viewModel: CoursesViewModel = koinViewModel()) {
    Column(
        modifier = Modifier
            .clickable {

            }
            .fillMaxSize(),
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        Text("Details")

        Text(
            text = "Back " + course.toJson() ,
            modifier = Modifier.clickable {
                onNavigate()
            }
        )
    }
}