package data.local

import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import platform.Foundation.NSFileManager

@OptIn(ExperimentalForeignApi::class)
actual val directoryPath: String
    get() {
        val baseDirectory = NSHomeDirectory()
        val appDirectory = baseDirectory + "/" + directoryNameOfApp

        /*if (!appDirectory.exists()) {
            appDirectory.mkdirs()
        }*/

        val fileManager = NSFileManager.defaultManager
        if (!fileManager.fileExistsAtPath(appDirectory)) {
            fileManager.createDirectoryAtPath(appDirectory, true, null, null)
        }

        return appDirectory + "/"
    }