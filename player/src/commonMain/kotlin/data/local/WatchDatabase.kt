package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import androidx.sqlite.execSQL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [WatchProgress::class], version = 2)
abstract class WatchDatabase : RoomDatabase() {
    abstract fun watchProgressDao(): WatchProgressDao
}

internal const val dbFileName = "watch_progress.db"

expect class WatchDatabaseInit {
    fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase>


}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE watch_progress ADD COLUMN duration INTEGER NOT NULL DEFAULT 0")
    }
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<WatchDatabase>
): WatchDatabase {
    return builder
        .addMigrations(MIGRATION_1_2)
        //.fallbackToDestructiveMigrationOnDowngrade()
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
