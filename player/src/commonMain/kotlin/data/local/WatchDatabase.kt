package data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WatchProgress::class], version = 1)
abstract class WatchDatabase : RoomDatabase() {
    abstract fun watchProgressDao(): WatchProgressDao
}

internal const val dbFileName = "watch_progress.db"
expect class WatchDatabaseInit {
    fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase>
}