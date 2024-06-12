import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class VideoPlayerState(
    val player: XVideoPlayer,
    val content: @Composable (Modifier) -> Unit
)