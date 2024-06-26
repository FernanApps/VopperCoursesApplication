import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import data.local.WatchDatabaseInit
import data.local.WatchProgressRepository
import data.local.getRoomDatabase
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer

// https://github.com/JetBrains/compose-multiplatform/pull/2306
@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {

    val repository = remember {
        WatchProgressRepository(getRoomDatabase(WatchDatabaseInit().getDatabaseBuilder()))
    }


    val component = remember { defaultComponent() }
    val kVideoPlayer = remember { XVideoPlayer(component) }
    val surface = remember {
        SkiaBitmapVideoSurface().also {
            (kVideoPlayer.player as EmbeddedMediaPlayer).videoSurface().set(it)
        }
    }
    return remember {
        VideoPlayerState(
            player = kVideoPlayer,
            content = {
                surface.bitmap.value?.let { bitmap ->
                    Image(
                        bitmap,
                        modifier = it
                            .background(Color.Transparent)
                            .fillMaxSize(),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.Center,
                    )
                }
            },
            repository
        )
    }
}