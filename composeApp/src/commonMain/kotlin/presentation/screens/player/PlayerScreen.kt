package presentation.screens.player

import VideoPlayer2
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.local.directoryPath
import presentation.components.IconButtonBack


@Composable
fun PlayerScreen(videoUrl: String, title: String, onBack: () -> Unit) {

    val baseAppDirectory = directoryPath
    VideoPlayer2(
        modifier = Modifier.fillMaxWidth(),
        snapshotDirectory = {
            baseAppDirectory
        },
        title = title,
        url = videoUrl,
        onBack = onBack
    )

}