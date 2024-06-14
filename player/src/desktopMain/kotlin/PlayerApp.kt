import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {

    val url  = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val title = getPlatform()
    Window(
        onCloseRequest = ::exitApplication,
        title = "VopperCourses $title",
    ) {
        VideoPlayer2(modifier = Modifier.fillMaxWidth(), url){

        }
    }
}