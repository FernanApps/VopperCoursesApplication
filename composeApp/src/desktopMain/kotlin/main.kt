
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.local.directoryNameOfApp
import di.KoinInitializer
import java.io.File


fun main() = application {
    KoinInitializer().init()

    Window(
        onCloseRequest = ::exitApplication,
        title = directoryNameOfApp,
    ) {

        /*
        val path = "C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-1.jpg"

        AsyncImage(
            modifier = Modifier.width(200.dp).height(100.dp),
            model = path,
            //path = "file://C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-1.jpg",
            contentDescription = "contentDescription",
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            alpha = DefaultAlpha,
            colorFilter = null
        )

        return@Window
        coil3.compose.AsyncImage(
            modifier = Modifier.width(200.dp).height(100.dp),
            //model = PathUtils.fixImagePath(directoryPath + chapter.thumbnail),
            model = "file://C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-1.jpg",
            //model = "C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-1.jpg",
            contentDescription = "contentDescription",
            contentScale = ContentScale.Fit,
            onError = {
                println(it.result.throwable.message)
            },
            onLoading = {},
            onSuccess = {}
        )
        return@Window
        */
        App()
        //ProgressBarExample()
        //TestImage()
    }
}

@Composable
fun TestImage(modifier: Modifier = Modifier) {
    val baseDirectory = File(System.getProperty("java.io.tmpdir"))
    val ssss = "C:\\Users\\ADMIN\\AppData\\Local\\Temp\\VopperCourses\\Curso_Angulardesdecero-1.jpg"
    val appDirectory = File(ssss)

    if (!appDirectory.exists()) {
        println("no existe pe")
    } else {
        println(ssss)
    }

    /*
    Image(
        painter = rewme===(File("imageUrl")),
        contentDescription = "image",
        modifier = Modifier.fillMaxSize()
    )
    */
    coil3.compose.AsyncImage(
        modifier = Modifier.fillMaxSize(),
        //model = "https://www.hollywoodreporter.com/wp-content/uploads/2018/09/simpsons_header-h_2018.jpg?w=1296",
        model = ssss,
        contentDescription = "contentDescription",
        contentScale = ContentScale.Crop,
        onError = {
            it.result.throwable.printStackTrace()
        },
        onLoading = {},
        onSuccess = {}
    )
}



// https://github.com/JetBrains/compose-multiplatform/blob/master/components/resources/demo/shared/src/commonMain/kotlin/org/jetbrains/compose/resources/demo/shared/ImagesRes.kt


