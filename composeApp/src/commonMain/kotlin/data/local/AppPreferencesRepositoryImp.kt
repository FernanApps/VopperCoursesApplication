package data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import data.local.datastore.DataStoreManager
import domain.repository.AppPreferencesRepository


internal class AppPreferencesRepositoryImp(
    dataStore: DataStore<Preferences>
) : DataStoreManager(dataStore), AppPreferencesRepository {

    private companion object {
        private const val PREFS_TAG_KEY = "AppPreferences"

        private const val KEY_DARK_MODE = "${PREFS_TAG_KEY}KEY_DARK_MODE"
        private const val KEY_USER_NAME = "${PREFS_TAG_KEY}KEY_USER_NAME"
    }


    override suspend fun isDarkModeEnabled(): Boolean = getBoolean(KEY_DARK_MODE)
    override suspend fun changeDarkMode(isEnabled: Boolean) = putBoolean(KEY_DARK_MODE, isEnabled)

    override suspend fun addUserName(name: String)  = putString(KEY_USER_NAME, name)
    override suspend fun getUserName(): String  = getString(KEY_USER_NAME)
}