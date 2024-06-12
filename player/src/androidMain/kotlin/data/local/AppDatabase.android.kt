package data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers


actual class WatchDatabaseInit(private val ctx: Context) {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase> {
        val appContext = ctx.applicationContext
        val dbFile = appContext.getDatabasePath(dbFileName)
        return Room.databaseBuilder<WatchDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}