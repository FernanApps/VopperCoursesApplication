package data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_progress")
data class WatchProgress(
    @PrimaryKey(autoGenerate = false) val mediaId: String = "",
    val position: Long,
    val duration: Long
) {
    fun getProgressPercentage(): Int {
        return if (duration > 0) {
            ((position.toDouble() / duration) * 100).toInt()
        } else {
            0
        }
    }
}