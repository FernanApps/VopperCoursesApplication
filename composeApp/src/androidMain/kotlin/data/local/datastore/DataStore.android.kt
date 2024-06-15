package data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import applicationContext
import data.local.directoryPath
import kotlinx.coroutines.runBlocking
import java.io.File


actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = { File(directoryPath).resolve(dataStoreFileName).absolutePath })
    }
}