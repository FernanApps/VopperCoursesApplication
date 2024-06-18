package presentation.components.shared

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File


@Composable
actual fun AsyncImage(
    model: String,
    contentDescription: String,
    modifier: Modifier,
    alignment: Alignment,
    contentScale: ContentScale,
    alpha: Float,
    colorFilter: ColorFilter?
) {
    val image: ImageBitmap? by produceState<ImageBitmap?>(null) {
        value = withContext(Dispatchers.IO) {
            try {
                presentation.components.shared.loadImageBitmap(File(model))
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    if (image != null) {
        Image(
            painter = remember { BitmapPainter(image!!) },
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = modifier,
            alignment = alignment,
            alpha = alpha,
            colorFilter = colorFilter
        )
    }
}


/* Loading from file with java.io API */

fun loadImageBitmap(file: File): ImageBitmap =
    file.inputStream().buffered().use(::loadImageBitmap)
