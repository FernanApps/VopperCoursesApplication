package data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_progress")
data class WatchProgress(
    @PrimaryKey(autoGenerate = false) val mediaId: String = "",
    val position: Long
)