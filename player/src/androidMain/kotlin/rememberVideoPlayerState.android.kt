import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView
import data.local.WatchDatabase
import data.local.WatchDatabaseInit
import data.local.WatchProgressRepository
import data.local.getRoomDatabase


@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    val context = LocalContext.current
    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit(context).getDatabaseBuilder()))
    }
    return remember {
        val view = PlayerView(context)
        VideoPlayerState(
            player = XVideoPlayer(view),
            content = {
                AndroidView(
                    factory = {
                        view
                    },
                    modifier = it
                )
            },
            repository
        )
    }
}