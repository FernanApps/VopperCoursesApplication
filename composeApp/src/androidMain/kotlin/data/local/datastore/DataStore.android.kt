package data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import applicationContext
import kotlinx.coroutines.runBlocking


actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = { applicationContext.filesDir.resolve(dataStoreFileName).absolutePath })
    }
}