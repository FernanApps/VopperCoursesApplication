package data.local

import java.io.File

actual val directoryPath: String
    get() {
        val baseDirectory = File(System.getProperty("java.io.tmpdir"))
        val appDirectory = File(baseDirectory, directoryNameOfApp)

        if (!appDirectory.exists()) {
            appDirectory.mkdirs()
        }
        return appDirectory.absolutePath + File.separator
    }
