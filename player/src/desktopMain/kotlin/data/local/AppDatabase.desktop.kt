package data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


actual class WatchDatabaseInit {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<WatchDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
        return Room.databaseBuilder<WatchDatabase>(
            name = dbFile.absolutePath,
        )
    }
}