package utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.skiko.hostOs
import java.io.File


actual suspend fun checkAppInstalls(): Application? {
    println("host $hostOs")
    if (hostOs.isMacOS) {
        for (app in mandatoryAppsInMacOs) {
            val isInstalled = isInstalledInMacOs(app.name)
            println("host ${app.name} $isInstalled")

            if (!isInstalled) {
                return app
            }
        }
    }
    return null
}


private suspend fun isInstalledInMacOs(appName: String): Boolean {
    return try {
        withContext(Dispatchers.Default) {
            val appPaths = listOf(
                "/Applications/$appName.app",
                "/usr/local/bin/$appName"
                // add other routes
            )

            for (path in appPaths) {
                val file = File(path)
                if (file.exists() && file.canExecute()) {
                    return@withContext true
                }
            }
            false
        }
    } catch (e: Exception) {
        // Handle exceptions during process execution
        false
    }
}