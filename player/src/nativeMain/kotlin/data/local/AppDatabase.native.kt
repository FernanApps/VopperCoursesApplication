package data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers


actual class WatchDatabaseInit {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase> {
        val dbFilePath = NSHomeDirectory() + "/$dbFileName"
        return Room.databaseBuilder<WatchDatabase>(
            name = dbFilePath,
            factory = { WatchDatabase::class.instantiateImpl() }
        )
    }

}