package data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

abstract class DataStoreManager constructor(val dataStore: DataStore<Preferences>) {

    suspend fun putString(key: String, value: String) {
        put(key, value)
    }

    suspend fun putInt(key: String, value: Int) {
        put(key, value)
    }

    suspend fun putDouble(key: String, value: Double) {
        put(key, value)
    }

    suspend fun putBoolean(key: String, value: Boolean) {
        put(key, value)
    }

    suspend fun putFloat(key: String, value: Float) {
        put(key, value)
    }

    suspend fun putLong(key: String, value: Long) {
        put(key, value)
    }

    suspend fun putSet(key: String, value: Set<String>) {
        put(key, value)
    }

    suspend inline fun <reified T> put(key: String, value: T) {
        dataStore.edit { preferences ->
            when (value) {
                is String -> preferences[stringPreferencesKey(key)] = value
                is Int -> preferences[intPreferencesKey(key)] = value
                is Double -> preferences[doublePreferencesKey(key)] = value
                is Boolean -> preferences[booleanPreferencesKey(key)] = value
                is Float -> preferences[floatPreferencesKey(key)] = value
                is Long -> preferences[longPreferencesKey(key)] = value
                is Set<*> -> preferences[stringSetPreferencesKey(key)] = value as Set<String>
                else -> throw UnsupportedOperationException("Type not supported")
            }
        }
    }

    suspend inline fun <reified T> remove(key: String) {
        val preferencesKey = getPreferencesKey<T>(key)
        dataStore.edit {
            it.remove(preferencesKey)
        }
    }

    inline fun <reified T> getPreferencesKey(key: String): Preferences.Key<out Any> {
        val preferencesKey = when (T::class) {
            String::class -> stringPreferencesKey(key)
            Int::class -> intPreferencesKey(key)
            Double::class -> doublePreferencesKey(key)
            Boolean::class -> booleanPreferencesKey(key)
            Float::class -> floatPreferencesKey(key)
            Long::class -> longPreferencesKey(key)
            Set::class -> stringSetPreferencesKey(key)
            else -> throw UnsupportedOperationException("Type not supported")
        }
        return preferencesKey
    }




    suspend fun getString(key: String, defaultValue: String = "") = getValue(key, defaultValue)

    suspend fun getInt(key: String, defaultValue: Int = 0) = getValue(key, defaultValue)

    suspend fun getDouble(key: String, defaultValue: Double = 0.0) = getValue(key, defaultValue)

    suspend fun getBoolean(key: String, defaultValue: Boolean = false) = getValue(key, defaultValue)

    suspend fun getFloat(key: String, defaultValue: Float = 0f) = getValue(key, defaultValue)

    suspend fun getLong(key: String, defaultValue: Long = 0L) = getValue(key, defaultValue)

    suspend fun getSet(key: String, defaultValue: Set<String> = emptySet()) = getValue(key, defaultValue)

    suspend inline fun <reified T> getValue(key: String, defaultValue: T): T {
        return get(key, defaultValue).firstOrNull() ?: defaultValue
    }

    inline fun <reified T> get(key: String, defaultValue: T): Flow<T?> {
        val preferencesKey = getPreferencesKey<T>(key)
        return dataStore.data.map { preferences ->
            preferences[preferencesKey] as? T ?: defaultValue
        }
    }

    inline fun <reified T> getOrNull(key: String): Flow<T?> {
        val preferencesKey = getPreferencesKey<T>(key)
        return dataStore.data.map { preferences ->
            preferences[preferencesKey] as? T
        }
    }


    val allData: Flow<Map<Preferences.Key<*>, Any>> = dataStore.data.map { preferences ->
        preferences.asMap()
    }
}