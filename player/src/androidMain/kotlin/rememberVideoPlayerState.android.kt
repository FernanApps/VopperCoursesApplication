import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.ui.PlayerView

@Composable
actual fun rememberVideoPlayerState(): VideoPlayerState {
    val context = LocalContext.current
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
            }
        )
    }
}