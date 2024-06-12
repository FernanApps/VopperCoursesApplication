package presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import com.materialkolor.rememberDynamicColorScheme
import presentation.theme.background1
import presentation.theme.background2




@Composable
fun VopperCoursesTheme(
    seedColor: Color,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {


    val colorScheme =
        rememberDynamicColorScheme(seedColor, useDarkTheme, style = PaletteStyle.Vibrant)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = NunitoTypography()
    )
}