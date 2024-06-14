package data.local

class WatchProgressRepository(private val watchDatabase: WatchDatabase) {

    private val watchProgressDao by lazy {
        watchDatabase.watchProgressDao()
    }
    suspend fun insertWatchProgress(title: String, position: Long, duration: Long) {
        val watchProgress = WatchProgress(mediaId = createMediaId(title), position = position, duration = duration)
        watchProgressDao.insert(watchProgress)
    }

    suspend fun updateWatchProgress(watchProgress: WatchProgress) {
        watchProgressDao.update(watchProgress)
    }

    suspend fun getWatchProgress(title: String): WatchProgress? {
        return watchProgressDao.getWatchProgress(createMediaId(title))
    }


    suspend fun deleteWatchProgress(title: String) {
        watchProgressDao.deleteWatchProgress(createMediaId(title))
    }

    suspend fun getAllWatchProgress(): List<WatchProgress> {
        return watchProgressDao.getAllWatchProgress()
    }

    fun getAllWatchProgressAsFlow() = watchProgressDao.getAllWatchProgressAsFlow()


    fun createMediaId(data: String) = data.replace(" ", "")
}