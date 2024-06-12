package presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import com.materialkolor.ktx.darken

val subTitleTextStyle: TextStyle
    @Composable get() = MaterialTheme.typography.headlineSmall
/*
@Composable get() = when (LocalWindowSizeWidth.current) {
    WindowSize.Expanded -> MaterialTheme.typography.displaySmall
    WindowSize.Medium -> MaterialTheme.typography.headlineMedium
    else -> // WindowWidthSizeClass.Compact
        MaterialTheme.typography.headlineSmall
}
*/


val verticalBackground
    @Composable get() = Brush.verticalGradient(
    colors = listOf(
        MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.background.darken()
    )
)
