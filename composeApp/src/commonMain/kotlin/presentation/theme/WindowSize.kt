package presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf

enum class WindowSize {
    Compact, Medium, Expanded
}

internal val LocalWindowSizeHeight = staticCompositionLocalOf<WindowSize> {
    error("CompositionLocal LocalWindowSizeClass not present")
}

internal val LocalWindowSizeWidth = staticCompositionLocalOf<WindowSize> {
    error("CompositionLocal LocalWindowSizeClass not present")
}