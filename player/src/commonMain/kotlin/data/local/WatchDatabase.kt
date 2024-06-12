package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [WatchProgress::class], version = 1)
abstract class WatchDatabase : RoomDatabase() {
    abstract fun watchProgressDao(): WatchProgressDao
}

internal const val dbFileName = "watch_progress.db"

expect class WatchDatabaseInit {
    fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase>


}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<WatchDatabase>
): WatchDatabase {
    return builder
        //.addMigrations(MIGRATIONS)
        //.fallbackToDestructiveMigrationOnDowngrade()
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
