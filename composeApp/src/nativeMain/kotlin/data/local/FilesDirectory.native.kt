package data.local

import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
actual val directoryPath: String
    get() {
        val baseDirectory = NSHomeDirectory()
        val appDirectory = baseDirectory + "/" directoryNameOfApp

        /*if (!appDirectory.exists()) {
            appDirectory.mkdirs()
        }*/
        return appDirectory + "/"
    }