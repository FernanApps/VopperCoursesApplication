import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import data.local.WatchDatabaseInit
import data.local.WatchProgressRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
expect fun VideoPlayer(modifier: Modifier, url: String)

@Composable
fun VideoPlayer2(modifier: Modifier, url: String){
    val (player, videoLayout, repository) = rememberVideoPlayerState()

    LaunchedEffect(player) {
        player.apply {
            prepare(url)
        }
    }

    val status by player.status.collectAsState(XPlayerStatus.Idle)
    val volume by player.volume.collectAsState(1f)
    val isMuted by player.isMute.collectAsState(false)
    val duration by player.duration.collectAsState(0L)
    val currentTime by player.currentTime.collectAsState(0L)
    val isRepeated by player.isRepeated.collectAsState(false)

    //println("status: $status, $volume, $isMuted, $currentTime, $duration")
    var seek: Float by remember { mutableStateOf(0f) }
    var seeking: Boolean by remember { mutableStateOf(false) }


    val coroutineScope = rememberCoroutineScope()
    var isVisibleSurface by remember { mutableStateOf(true) }
    var jobSurface: Job? by remember { mutableStateOf(null) }

    fun setVisibleSurface(value: Boolean = true) {
        isVisibleSurface = value
    }

    LaunchedEffect(isVisibleSurface) {
        jobSurface?.cancel()
        jobSurface = coroutineScope.launch {
            if (isVisibleSurface) {
                delay(3000)
                setVisibleSurface(false)
            }
        }
    }

    LaunchedEffect(seek){
        println("Av $seek")
    }

    videoLayout.invoke(modifier)


}
