import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.local.WatchProgressRepository

data class VideoPlayerState(
    val player: XVideoPlayer,
    val content: @Composable (Modifier) -> Unit,
    val repository: WatchProgressRepository
)