package data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(watchProgress: WatchProgress)

    @Update
    suspend fun update(watchProgress: WatchProgress)

    @Query("SELECT * FROM watch_progress WHERE mediaId = :mediaId")
    suspend fun getWatchProgress(mediaId: String): WatchProgress?

    @Query("DELETE FROM watch_progress WHERE mediaId = :mediaId")
    suspend fun deleteWatchProgress(mediaId: String)

    @Query("SELECT * FROM watch_progress")
    suspend fun getAllWatchProgress(): List<WatchProgress>

    @Query("SELECT * FROM watch_progress")
    fun getAllWatchProgressAsFlow(): Flow<List<WatchProgress>>

}
