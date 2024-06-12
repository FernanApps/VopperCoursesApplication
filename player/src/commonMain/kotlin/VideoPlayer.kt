import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf


@Composable
expect fun VideoPlayer(modifier: Modifier, url: String)

@Composable
fun VideoPlayer2(modifier: Modifier, url: String){
    val (player, videoLayout) = rememberVideoPlayerState()
    val newLinkVideo by remember {
        mutableStateOf(url)
    }

    player.stop()

    LaunchedEffect(player) {
        player.apply {
            prepare(newLinkVideo)
        }
    }
    videoLayout.invoke(modifier)


}
