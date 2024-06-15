package data.local

import applicationContext
import java.io.File

actual val directoryPath: String
    get() {
        val baseDirectory = applicationContext.filesDir
        val appDirectory = File(baseDirectory, directoryNameOfApp)

        if (!appDirectory.exists()) {
            appDirectory.mkdirs()
        }
        return appDirectory.absolutePath
    }
