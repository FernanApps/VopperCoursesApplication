package domain.repository

interface AppPreferencesRepository {
    suspend fun isDarkModeEnabled(): Boolean
    suspend fun changeDarkMode(isEnabled: Boolean)

    suspend fun addUserName(name: String)
        suspend fun getUserName(): String

}