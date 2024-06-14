package data.local

class WatchProgressRepository(private val watchProgressDao: WatchProgressDao) {

    suspend fun insertWatchProgress(mediaId: String, position: Long) {
        val watchProgress = WatchProgress(mediaId = mediaId, position = position)
        watchProgressDao.insert(watchProgress)
    }

    suspend fun updateWatchProgress(watchProgress: WatchProgress) {
        watchProgressDao.update(watchProgress)
    }

    suspend fun getWatchProgress(mediaId: String): WatchProgress? {
        return watchProgressDao.getWatchProgress(mediaId)
    }

    suspend fun deleteWatchProgress(mediaId: String) {
        watchProgressDao.deleteWatchProgress(mediaId)
    }

    suspend fun getAllWatchProgress(): List<WatchProgress> {
        return watchProgressDao.getAllWatchProgress()
    }
}