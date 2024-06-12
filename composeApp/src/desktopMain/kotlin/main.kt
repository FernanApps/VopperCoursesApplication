import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.KoinInitializer

fun main() = application {
    KoinInitializer().init()

    val title = getPlatform()
    Window(
        onCloseRequest = ::exitApplication,
        title = "VopperCourses $title",
    ) {
        App()
    }
}