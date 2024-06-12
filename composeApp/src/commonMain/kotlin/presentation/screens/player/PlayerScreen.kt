package presentation.screens.player

import VideoPlayer
import VideoPlayer2
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.components.IconButtonBack


@Composable
fun PlayerScreen(videoUrl: String, onBack: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            IconButtonBack(onBack)
            Box {
                Text(videoUrl)

                VideoPlayer2(
                    modifier = Modifier.fillMaxWidth().height(400.dp),
                    url = videoUrl
                )

                Text(videoUrl)

            }

        }
    }
}