package utils

import org.jetbrains.skiko.hostOs

object PathUtils {

    fun fixImagePath(path: String): String {
        println("fix $path")
        println("fix $hostOs")
        return if (hostOs.isWindows) {
            println("fix $hostOs")
            val path = "file://" + path.replace("\\", "/")
            println("fix $path")
            path
        } else {
            path
        }
    }

}

/*
ruta loc
    file://C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-1.jpg

fix file://C:/Users/ADMIN/AppData/Local/Temp/VopperCourses/Curso_Angulardesdecero-7.jpg


 */