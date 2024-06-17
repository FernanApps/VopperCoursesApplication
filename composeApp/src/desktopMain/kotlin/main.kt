
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.KoinInitializer
import java.io.File


fun main() = application {
    KoinInitializer().init()

    Window(
        onCloseRequest = ::exitApplication,
        title = "VopperCourses",
    ) {
        App()
        //ProgressBarExample()
        //TestImage()
    }
}

@Composable
fun TestImage(modifier: Modifier = Modifier) {
    val baseDirectory = File(System.getProperty("java.io.tmpdir"))
    val ssss = "VopperCourses" + File.separator + "Curso_Angulardesdecero-1.jpg"
    val appDirectory = File(baseDirectory, ssss)

    if (!appDirectory.exists()) {
        println("no existe pe")
    }

    /*
    Image(
        painter = rewme===(File("imageUrl")),
        contentDescription = "image",
        modifier = Modifier.fillMaxSize()
    )
    */
    /*AsyncImage(
        modifier = Modifier.fillMaxSize(),
        model = appDirectory,
        contentDescription = "contentDescription",
        contentScale = ContentScale.Crop,
        onError = {},
        onLoading = {},
        onSuccess = {}
    )*/
}
