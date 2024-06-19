package data.local.datastore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import data.local.directoryPath
import kotlinx.atomicfu.locks.synchronized
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject
import kotlinx.coroutines.runBlocking
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = {

            /*
            val documentDirectoryPath = directoryPath

            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                //directory = NSDocumentDirectory,
                directory = documentDirectoryUrl,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            */
            val dataStorePath = "$directoryPath/$dataStoreFileName"

            //requireNotNull(documentDirectory).path + "/$dataStoreFileName"
            dataStorePath
        })
    }
}