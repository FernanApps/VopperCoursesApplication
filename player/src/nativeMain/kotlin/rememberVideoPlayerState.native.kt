import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import data.local.WatchDatabaseInit
import data.local.WatchProgressRepository
import data.local.getRoomDatabase

@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder()).watchProgressDao())
    }
    TODO("Not yet implemented")
}