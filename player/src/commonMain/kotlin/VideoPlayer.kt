import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.rounded.FastForward
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch


@Composable
expect fun VideoPlayer(modifier: Modifier, url: String)

// Other Examples https://github.com/rjuszczyk/ComposeVideoPlayer
@Composable
fun VideoPlayer2(modifier: Modifier, title: String, url: String, onBack: () -> Unit) {
    val (player, videoLayout, repository) = rememberVideoPlayerState()


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


    DisposableEffect(player) {
        player.apply {
            prepare(url)
        }
        onDispose {
            coroutineScope.launch(Dispatchers.IO) {
                repository.insertWatchProgress(title = title, position = currentTime, duration = duration)
            }
            player.release()
        }

    }

    val hasStartedPlayback = remember { mutableStateOf(false) }

    LaunchedEffect(isVisibleSurface) {
        jobSurface?.cancel()
        jobSurface = coroutineScope.launch {
            if (isVisibleSurface) {
                delay(3000)
                setVisibleSurface(false)
            }
        }
    }


    LaunchedEffect(status) {
        if (status == XPlayerStatus.Playing && !hasStartedPlayback.value) {
            val position = repository.getWatchProgress(title)?.position ?: 0L
            player.pause()
            player.seekTo(position)
            player.play()
            hasStartedPlayback.value = true
        }
    }

    val isPlay = when (status) {
        XPlayerStatus.Playing -> true
        else -> false
    }

    Box(modifier = modifier) {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 20.dp).padding(top = 20.dp)
            ) {

                IconButton(onClick = {
                    onBack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBackIosNew, "ArrowBackIosNew")
                }
                Text(title, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }

            Box(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                videoLayout.invoke(Modifier.fillMaxSize())
                if (status == XPlayerStatus.Buffering) {
                    CircularProgressIndicator()
                }

            }



            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp)
            ) {


                IconButton(
                    enabled = status !is XPlayerStatus.Buffering,
                    onClick = {
                        when (status) {
                            XPlayerStatus.Playing -> player.pause()
                            else -> player.play()
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (isPlay) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                        contentDescription = "skip_back",
                    )
                }
                IconButton(
                    enabled = status !is XPlayerStatus.Buffering,
                    onClick = {
                        if (currentTime + 10000 > duration) {
                            player.seekTo(duration)
                        } else {
                            player.seekTo(currentTime + 10000)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FastForward,
                        contentDescription = "skip_back",
                    )
                }



                Spacer(Modifier.size(10.dp))
                Text(TimeUtils.getStringForTime(currentTime))
                Spacer(Modifier.size(10.dp))

                Slider(
                    value = currentTime.toFloat(),
                    enabled = duration > 0,
                    valueRange = 0f..(if(duration > 0) duration.toFloat() else 1F),
                    onValueChange = {
                        player.seekTo(it.toLong())
                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.size(10.dp))
                Text(TimeUtils.getStringForTime(duration))


            }


        }
    }


}
