
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {

    val url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val title = getPlatform()
    Window(
        onCloseRequest = ::exitApplication,
        title = "VopperCourses $title",
    ) {



        /*Image(
            painter = painterResource(appDirectory.absolutePath),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )*/

        return@Window
        VideoPlayer2(modifier = Modifier.fillMaxWidth(), title = "Video de Prueba", url) {
            exitApplication()
        }
    }
}


