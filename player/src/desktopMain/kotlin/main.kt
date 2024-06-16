import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.seiko.imageloader.rememberImagePainter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path


fun main() = application {

    val url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val title = getPlatform()
    Window(
        onCloseRequest = ::exitApplication,
        title = "VopperCourses $title",
    ) {

        val baseDirectory = File(System.getProperty("java.io.tmpdir"))
        val ssss = "VopperCourses" + File.separator + "Curso_Angulardesdecero-1.jpg"
        val appDirectory = File(baseDirectory, ssss)

        if (!appDirectory.exists()) {
            println("no existe pe")
        }

        Image(
            painter = rewme===(File("imageUrl")),
            contentDescription = "image",
            modifier = Modifier.fillMaxSize()
        )

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
fun loadImageFrom(filePath: String): ImageBitmap {
    val bytes = Files.readAllBytes(Path.of(filePath)) // path relative to project root
    return Image.makeFromEncoded(bytes).toComposeImageBitmap()
}

