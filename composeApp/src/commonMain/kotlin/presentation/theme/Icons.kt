package presentation.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

private var _PersonOutlineRounded: ImageVector? = null
public val Icons.PersonOutlineRounded: ImageVector
    get() {
        if (_PersonOutlineRounded != null) {
            return _PersonOutlineRounded!!
        }
        _PersonOutlineRounded = materialIcon(name = "_PersonOutlineRounded") {
            PersonOutlineRounded()
        }
        return _PersonOutlineRounded!!
    }

private var _PersonFilledRounded: ImageVector? = null
public val Icons.PersonFilledRounded: ImageVector
    get() {
        if (_PersonFilledRounded != null) {
            return _PersonFilledRounded!!
        }
        _PersonFilledRounded = materialIcon(name = "_PersonFilledRounded") {
            PersonFilledRounded()
        }
        return _PersonFilledRounded!!
    }

private var _SettingsOutlineRounded: ImageVector? = null
public val Icons.SettingsOutlineRounded: ImageVector
    get() {
        if (_SettingsOutlineRounded != null) {
            return _SettingsOutlineRounded!!
        }
        _SettingsOutlineRounded = materialIcon(name = "_SettingsOutlineRounded") {
            SettingsOutlineRounded()
        }
        return _SettingsOutlineRounded!!
    }

private var _SettingsFilledRounded: ImageVector? = null
public val Icons.SettingsFilledRounded: ImageVector
    get() {
        if (_SettingsFilledRounded != null) {
            return _SettingsFilledRounded!!
        }
        _SettingsFilledRounded = materialIcon(name = "_SettingsFilledRounded") {
            SettingsFilledRounded()
        }
        return _SettingsFilledRounded!!
    }

private var _HomeOutlineRounded: ImageVector? = null
public val Icons.HomeOutlineRounded: ImageVector
    get() {
        if (_HomeOutlineRounded != null) {
            return _HomeOutlineRounded!!
        }
        _HomeOutlineRounded = materialIcon(name = "_HomeOutlineRounded") {
            HomeOutlineRounded()
        }
        return _HomeOutlineRounded!!
    }

private var _HomeFilledRounded: ImageVector? = null
public val Icons.HomeFilledRounded: ImageVector
    get() {
        if (_HomeFilledRounded != null) {
            return _HomeFilledRounded!!
        }
        _HomeFilledRounded = materialIcon(name = "_HomeFilledRounded") {
            HomeFilledRounded()
        }
        return _HomeFilledRounded!!
    }


private fun PersonOutlineRounded(): ImageVector.Builder {
    return ImageVector.Builder(
        name = "person",
        defaultWidth = 40.0.dp,
        defaultHeight = 40.0.dp,
        viewportWidth = 40.0f,
        viewportHeight = 40.0f
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(20f, 19.875f)
            quadToRelative(-2.833f, 0f, -4.688f, -1.854f)
            quadToRelative(-1.854f, -1.854f, -1.854f, -4.688f)
            quadToRelative(0f, -2.833f, 1.854f, -4.687f)
            quadTo(17.167f, 6.792f, 20f, 6.792f)
            quadToRelative(2.833f, 0f, 4.688f, 1.854f)
            quadToRelative(1.854f, 1.854f, 1.854f, 4.687f)
            quadToRelative(0f, 2.834f, -1.854f, 4.688f)
            quadToRelative(-1.855f, 1.854f, -4.688f, 1.854f)
            close()
            moveToRelative(10.333f, 13.5f)
            horizontalLineTo(9.667f)
            quadToRelative(-1.25f, 0f, -2.146f, -0.875f)
            quadToRelative(-0.896f, -0.875f, -0.896f, -2.125f)
            verticalLineToRelative(-1.292f)
            quadToRelative(0f, -1.541f, 0.813f, -2.729f)
            quadToRelative(0.812f, -1.187f, 2.104f, -1.812f)
            quadToRelative(2.708f, -1.25f, 5.27f, -1.875f)
            quadToRelative(2.563f, -0.625f, 5.188f, -0.625f)
            quadToRelative(2.625f, 0f, 5.188f, 0.625f)
            quadToRelative(2.562f, 0.625f, 5.27f, 1.875f)
            quadToRelative(1.334f, 0.625f, 2.125f, 1.791f)
            quadToRelative(0.792f, 1.167f, 0.792f, 2.75f)
            verticalLineToRelative(1.292f)
            quadToRelative(0f, 1.25f, -0.896f, 2.125f)
            reflectiveQuadToRelative(-2.146f, 0.875f)
            close()
            moveToRelative(-20.666f, -3f)
            horizontalLineToRelative(20.666f)
            verticalLineToRelative(-1.25f)
            quadToRelative(0f, -0.583f, -0.333f, -1.104f)
            quadToRelative(-0.333f, -0.521f, -0.875f, -0.813f)
            quadToRelative(-2.458f, -1.166f, -4.625f, -1.666f)
            reflectiveQuadToRelative(-4.5f, -0.5f)
            quadToRelative(-2.333f, 0f, -4.521f, 0.5f)
            quadToRelative(-2.187f, 0.5f, -4.646f, 1.666f)
            quadToRelative(-0.5f, 0.292f, -0.833f, 0.813f)
            quadToRelative(-0.333f, 0.521f, -0.333f, 1.104f)
            close()
            moveTo(20f, 16.833f)
            quadToRelative(1.5f, 0f, 2.5f, -1f)
            reflectiveQuadToRelative(1f, -2.5f)
            quadToRelative(0f, -1.5f, -1f, -2.5f)
            reflectiveQuadToRelative(-2.5f, -1f)
            quadToRelative(-1.5f, 0f, -2.5f, 1f)
            reflectiveQuadToRelative(-1f, 2.5f)
            quadToRelative(0f, 1.5f, 1f, 2.5f)
            reflectiveQuadToRelative(2.5f, 1f)
            close()
            moveToRelative(0f, -3.5f)
            close()
            moveToRelative(0f, 17.042f)
            close()
        }
    }

}

private fun PersonFilledRounded(): ImageVector.Builder {
    return ImageVector.Builder(
        name = "person",
        defaultWidth = 40.0.dp,
        defaultHeight = 40.0.dp,
        viewportWidth = 40.0f,
        viewportHeight = 40.0f
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(20f, 19.875f)
            quadToRelative(-2.833f, 0f, -4.688f, -1.854f)
            quadToRelative(-1.854f, -1.854f, -1.854f, -4.688f)
            quadToRelative(0f, -2.833f, 1.854f, -4.687f)
            quadTo(17.167f, 6.792f, 20f, 6.792f)
            quadToRelative(2.833f, 0f, 4.688f, 1.854f)
            quadToRelative(1.854f, 1.854f, 1.854f, 4.687f)
            quadToRelative(0f, 2.834f, -1.854f, 4.688f)
            quadToRelative(-1.855f, 1.854f, -4.688f, 1.854f)
            close()
            moveToRelative(-10.333f, 13.5f)
            quadToRelative(-1.292f, 0f, -2.167f, -0.875f)
            quadToRelative(-0.875f, -0.875f, -0.875f, -2.125f)
            verticalLineToRelative(-1.292f)
            quadToRelative(0f, -1.541f, 0.792f, -2.729f)
            quadToRelative(0.791f, -1.187f, 2.125f, -1.812f)
            quadToRelative(2.708f, -1.25f, 5.27f, -1.875f)
            quadToRelative(2.563f, -0.625f, 5.188f, -0.625f)
            quadToRelative(2.625f, 0f, 5.188f, 0.625f)
            quadToRelative(2.562f, 0.625f, 5.27f, 1.875f)
            quadToRelative(1.334f, 0.625f, 2.125f, 1.791f)
            quadToRelative(0.792f, 1.167f, 0.792f, 2.75f)
            verticalLineToRelative(1.292f)
            quadToRelative(0f, 1.25f, -0.875f, 2.125f)
            reflectiveQuadToRelative(-2.167f, 0.875f)
            close()
        }
    }

}

private fun SettingsOutlineRounded(): ImageVector.Builder {
    return ImageVector.Builder(
        name = "settings",
        defaultWidth = 40.0.dp,
        defaultHeight = 40.0.dp,
        viewportWidth = 40.0f,
        viewportHeight = 40.0f
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(22.875f, 36.667f)
            horizontalLineToRelative(-5.75f)
            quadToRelative(-0.542f, 0f, -0.979f, -0.355f)
            quadToRelative(-0.438f, -0.354f, -0.521f, -0.937f)
            lineToRelative(-0.583f, -4f)
            quadToRelative(-0.334f, -0.083f, -1.063f, -0.5f)
            quadToRelative(-0.729f, -0.417f, -1.604f, -0.958f)
            lineToRelative(-3.667f, 1.666f)
            quadToRelative(-0.541f, 0.209f, -1.104f, 0.021f)
            quadToRelative(-0.562f, -0.187f, -0.812f, -0.687f)
            lineToRelative(-2.917f, -5.084f)
            quadToRelative(-0.292f, -0.5f, -0.146f, -1.062f)
            quadToRelative(0.146f, -0.563f, 0.604f, -0.896f)
            lineToRelative(3.334f, -2.5f)
            quadToRelative(-0.042f, -0.292f, -0.063f, -0.646f)
            quadToRelative(-0.021f, -0.354f, -0.021f, -0.729f)
            quadToRelative(0f, -0.292f, 0.021f, -0.688f)
            quadToRelative(0.021f, -0.395f, 0.063f, -0.729f)
            lineToRelative(-3.334f, -2.5f)
            quadToRelative(-0.458f, -0.333f, -0.604f, -0.895f)
            quadToRelative(-0.146f, -0.563f, 0.146f, -1.021f)
            lineTo(6.75f, 9.083f)
            quadToRelative(0.333f, -0.5f, 0.875f, -0.687f)
            quadToRelative(0.542f, -0.188f, 1.083f, 0.062f)
            lineToRelative(3.75f, 1.667f)
            quadToRelative(0.459f, -0.417f, 1.167f, -0.812f)
            quadToRelative(0.708f, -0.396f, 1.417f, -0.646f)
            lineToRelative(0.583f, -4.084f)
            quadToRelative(0.083f, -0.583f, 0.521f, -0.937f)
            quadToRelative(0.437f, -0.354f, 0.979f, -0.354f)
            horizontalLineToRelative(5.75f)
            quadToRelative(0.542f, 0f, 0.979f, 0.354f)
            quadToRelative(0.438f, 0.354f, 0.521f, 0.937f)
            lineToRelative(0.583f, 4f)
            quadToRelative(0.667f, 0.25f, 1.375f, 0.667f)
            quadToRelative(0.709f, 0.417f, 1.25f, 0.875f)
            lineToRelative(3.75f, -1.667f)
            quadToRelative(0.5f, -0.25f, 1.042f, -0.062f)
            quadToRelative(0.542f, 0.187f, 0.833f, 0.687f)
            lineToRelative(2.917f, 5.042f)
            quadToRelative(0.292f, 0.5f, 0.167f, 1.063f)
            quadToRelative(-0.125f, 0.562f, -0.625f, 0.895f)
            lineToRelative(-3.417f, 2.459f)
            quadToRelative(0.042f, 0.375f, 0.062f, 0.729f)
            quadToRelative(0.021f, 0.354f, 0.021f, 0.729f)
            reflectiveQuadToRelative(-0.021f, 0.729f)
            quadToRelative(-0.02f, 0.354f, -0.062f, 0.688f)
            lineToRelative(3.417f, 2.458f)
            quadToRelative(0.458f, 0.333f, 0.583f, 0.896f)
            quadToRelative(0.125f, 0.562f, -0.167f, 1.062f)
            lineToRelative(-2.875f, 5.084f)
            quadToRelative(-0.291f, 0.5f, -0.854f, 0.687f)
            quadToRelative(-0.562f, 0.188f, -1.062f, -0.062f)
            lineToRelative(-3.75f, -1.667f)
            quadToRelative(-0.459f, 0.417f, -1.125f, 0.813f)
            quadToRelative(-0.667f, 0.395f, -1.459f, 0.687f)
            lineToRelative(-0.583f, 4f)
            quadToRelative(-0.083f, 0.583f, -0.521f, 0.937f)
            quadToRelative(-0.437f, 0.355f, -0.979f, 0.355f)
            close()
            moveToRelative(-2.917f, -11.25f)
            quadToRelative(2.25f, 0f, 3.834f, -1.584f)
            quadTo(25.375f, 22.25f, 25.375f, 20f)
            reflectiveQuadToRelative(-1.583f, -3.833f)
            quadToRelative(-1.584f, -1.584f, -3.834f, -1.584f)
            quadToRelative(-2.291f, 0f, -3.854f, 1.584f)
            quadTo(14.542f, 17.75f, 14.542f, 20f)
            reflectiveQuadToRelative(1.562f, 3.833f)
            quadToRelative(1.563f, 1.584f, 3.854f, 1.584f)
            close()
            moveToRelative(0f, -2.625f)
            quadToRelative(-1.208f, 0f, -2f, -0.813f)
            quadToRelative(-0.791f, -0.812f, -0.791f, -1.979f)
            reflectiveQuadToRelative(0.791f, -1.979f)
            quadToRelative(0.792f, -0.813f, 2f, -0.813f)
            quadToRelative(1.125f, 0f, 1.938f, 0.813f)
            quadToRelative(0.812f, 0.812f, 0.812f, 1.979f)
            reflectiveQuadToRelative(-0.812f, 1.979f)
            quadToRelative(-0.813f, 0.813f, -1.938f, 0.813f)
            close()
            moveTo(20f, 19.958f)
            close()
            moveToRelative(-1.667f, 13.709f)
            horizontalLineToRelative(3.292f)
            lineToRelative(0.625f, -4.625f)
            quadToRelative(1.333f, -0.334f, 2.5f, -0.98f)
            quadToRelative(1.167f, -0.645f, 2.125f, -1.687f)
            lineToRelative(4.333f, 1.875f)
            lineToRelative(1.5f, -2.75f)
            lineToRelative(-3.791f, -2.792f)
            quadToRelative(0.166f, -0.708f, 0.271f, -1.375f)
            quadToRelative(0.104f, -0.666f, 0.104f, -1.333f)
            quadToRelative(0f, -0.708f, -0.084f, -1.354f)
            quadToRelative(-0.083f, -0.646f, -0.291f, -1.354f)
            lineToRelative(3.833f, -2.834f)
            lineToRelative(-1.542f, -2.75f)
            lineToRelative(-4.333f, 1.875f)
            quadToRelative(-0.917f, -1f, -2.104f, -1.708f)
            quadToRelative(-1.188f, -0.708f, -2.521f, -0.958f)
            lineToRelative(-0.583f, -4.584f)
            horizontalLineToRelative(-3.334f)
            lineToRelative(-0.541f, 4.584f)
            quadToRelative(-1.459f, 0.291f, -2.584f, 0.958f)
            reflectiveQuadToRelative(-2.166f, 1.708f)
            lineToRelative(-4.25f, -1.875f)
            lineToRelative(-1.542f, 2.75f)
            lineTo(11f, 17.25f)
            quadToRelative(-0.167f, 0.708f, -0.271f, 1.375f)
            quadToRelative(-0.104f, 0.667f, -0.104f, 1.333f)
            quadToRelative(0f, 0.709f, 0.083f, 1.375f)
            quadToRelative(0.084f, 0.667f, 0.25f, 1.417f)
            lineTo(7.25f, 25.5f)
            lineToRelative(1.542f, 2.75f)
            lineToRelative(4.25f, -1.833f)
            quadToRelative(1.041f, 1f, 2.208f, 1.666f)
            quadToRelative(1.167f, 0.667f, 2.542f, 1f)
            close()
        }
    }
}

private fun SettingsFilledRounded(): ImageVector.Builder {
    return ImageVector.Builder(
        name = "settings",
        defaultWidth = 40.0.dp,
        defaultHeight = 40.0.dp,
        viewportWidth = 40.0f,
        viewportHeight = 40.0f
    ).apply {
        path(
            fill = SolidColor(Color.Black),
            fillAlpha = 1f,
            stroke = null,
            strokeAlpha = 1f,
            strokeLineWidth = 1.0f,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 1f,
            pathFillType = PathFillType.NonZero
        ) {
            moveTo(22.875f, 36.667f)
            horizontalLineToRelative(-5.75f)
            quadToRelative(-0.542f, 0f, -0.979f, -0.355f)
            quadToRelative(-0.438f, -0.354f, -0.521f, -0.937f)
            lineToRelative(-0.583f, -4f)
            quadToRelative(-0.334f, -0.083f, -1.063f, -0.5f)
            quadToRelative(-0.729f, -0.417f, -1.604f, -0.958f)
            lineToRelative(-3.667f, 1.666f)
            quadToRelative(-0.541f, 0.209f, -1.104f, 0.021f)
            quadToRelative(-0.562f, -0.187f, -0.812f, -0.687f)
            lineToRelative(-2.917f, -5.084f)
            quadToRelative(-0.292f, -0.5f, -0.146f, -1.062f)
            quadToRelative(0.146f, -0.563f, 0.604f, -0.896f)
            lineToRelative(3.334f, -2.5f)
            quadToRelative(-0.042f, -0.292f, -0.063f, -0.646f)
            quadToRelative(-0.021f, -0.354f, -0.021f, -0.729f)
            quadToRelative(0f, -0.292f, 0.021f, -0.688f)
            quadToRelative(0.021f, -0.395f, 0.063f, -0.729f)
            lineToRelative(-3.334f, -2.5f)
            quadToRelative(-0.458f, -0.333f, -0.604f, -0.895f)
            quadToRelative(-0.146f, -0.563f, 0.146f, -1.021f)
            lineToRelative(2.917f, -5.084f)
            quadToRelative(0.291f, -0.5f, 0.833f, -0.687f)
            quadToRelative(0.542f, -0.188f, 1.083f, 0.062f)
            lineToRelative(3.75f, 1.667f)
            quadToRelative(0.459f, -0.417f, 1.167f, -0.812f)
            quadToRelative(0.708f, -0.396f, 1.417f, -0.646f)
            lineToRelative(0.583f, -4.084f)
            quadToRelative(0.083f, -0.583f, 0.521f, -0.937f)
            quadToRelative(0.437f, -0.354f, 0.979f, -0.354f)
            horizontalLineToRelative(5.75f)
            quadToRelative(0.542f, 0f, 0.979f, 0.354f)
            quadToRelative(0.438f, 0.354f, 0.521f, 0.937f)
            lineToRelative(0.583f, 4f)
            quadToRelative(0.667f, 0.25f, 1.375f, 0.667f)
            quadToRelative(0.709f, 0.417f, 1.25f, 0.875f)
            lineToRelative(3.75f, -1.667f)
            quadToRelative(0.5f, -0.25f, 1.042f, -0.062f)
            quadToRelative(0.542f, 0.187f, 0.833f, 0.687f)
            lineToRelative(2.917f, 5.042f)
            quadToRelative(0.292f, 0.5f, 0.167f, 1.063f)
            quadToRelative(-0.125f, 0.562f, -0.625f, 0.895f)
            lineToRelative(-3.417f, 2.5f)
            quadToRelative(0.042f, 0.334f, 0.062f, 0.688f)
            quadToRelative(0.021f, 0.354f, 0.021f, 0.729f)
            reflectiveQuadToRelative(-0.021f, 0.729f)
            quadToRelative(-0.02f, 0.354f, -0.062f, 0.688f)
            lineToRelative(3.417f, 2.458f)
            quadToRelative(0.458f, 0.333f, 0.583f, 0.896f)
            quadToRelative(0.125f, 0.562f, -0.167f, 1.062f)
            lineToRelative(-2.875f, 5.084f)
            quadToRelative(-0.291f, 0.5f, -0.854f, 0.687f)
            quadToRelative(-0.562f, 0.188f, -1.062f, -0.062f)
            lineToRelative(-3.75f, -1.667f)
            quadToRelative(-0.459f, 0.417f, -1.125f, 0.813f)
            quadToRelative(-0.667f, 0.395f, -1.459f, 0.687f)
            lineToRelative(-0.583f, 4f)
            quadToRelative(-0.083f, 0.583f, -0.521f, 0.937f)
            quadToRelative(-0.437f, 0.355f, -0.979f, 0.355f)
            close()
            moveToRelative(-2.917f, -11.25f)
            quadToRelative(2.25f, 0f, 3.834f, -1.584f)
            quadTo(25.375f, 22.25f, 25.375f, 20f)
            reflectiveQuadToRelative(-1.583f, -3.833f)
            quadToRelative(-1.584f, -1.584f, -3.834f, -1.584f)
            quadToRelative(-2.291f, 0f, -3.854f, 1.584f)
            quadTo(14.542f, 17.75f, 14.542f, 20f)
            reflectiveQuadToRelative(1.562f, 3.833f)
            quadToRelative(1.563f, 1.584f, 3.854f, 1.584f)
            close()
        }
    }

}

private fun HomeOutlineRounded(): ImageVector.Builder {
    return ImageVector.Builder(
            name = "home",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.667f, 32f)
                horizontalLineToRelative(5.416f)
                verticalLineTo(21.667f)
                horizontalLineToRelative(9.834f)
                verticalLineTo(32f)
                horizontalLineToRelative(5.416f)
                verticalLineTo(16.458f)
                lineTo(20f, 8.708f)
                lineToRelative(-10.333f, 7.75f)
                close()
                moveToRelative(0f, 3.042f)
                quadToRelative(-1.25f, 0f, -2.146f, -0.896f)
                quadToRelative(-0.896f, -0.896f, -0.896f, -2.146f)
                verticalLineTo(16.458f)
                quadToRelative(0f, -0.708f, 0.313f, -1.354f)
                quadToRelative(0.312f, -0.646f, 0.895f, -1.062f)
                lineToRelative(10.334f, -7.75f)
                quadToRelative(0.458f, -0.292f, 0.916f, -0.438f)
                quadToRelative(0.459f, -0.146f, 0.917f, -0.146f)
                quadToRelative(0.5f, 0f, 0.958f, 0.146f)
                quadToRelative(0.459f, 0.146f, 0.875f, 0.438f)
                lineToRelative(10.334f, 7.75f)
                quadToRelative(0.583f, 0.416f, 0.895f, 1.062f)
                quadToRelative(0.313f, 0.646f, 0.313f, 1.354f)
                verticalLineTo(32f)
                quadToRelative(0f, 1.25f, -0.896f, 2.146f)
                quadToRelative(-0.896f, 0.896f, -2.146f, 0.896f)
                horizontalLineTo(22f)
                verticalLineTo(24.583f)
                horizontalLineToRelative(-4f)
                verticalLineToRelative(10.459f)
                close()
                moveTo(20f, 20.333f)
                close()
            }
        }
    }


private fun HomeFilledRounded(): ImageVector.Builder {
    return ImageVector.Builder(
            name = "home",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(9.667f, 35.042f)
                quadToRelative(-1.25f, 0f, -2.146f, -0.896f)
                quadToRelative(-0.896f, -0.896f, -0.896f, -2.146f)
                verticalLineTo(16.458f)
                quadToRelative(0f, -0.708f, 0.313f, -1.354f)
                quadToRelative(0.312f, -0.646f, 0.895f, -1.062f)
                lineToRelative(10.334f, -7.75f)
                quadToRelative(0.458f, -0.292f, 0.916f, -0.438f)
                quadToRelative(0.459f, -0.146f, 0.917f, -0.146f)
                quadToRelative(0.5f, 0f, 0.958f, 0.146f)
                quadToRelative(0.459f, 0.146f, 0.875f, 0.438f)
                lineToRelative(10.334f, 7.75f)
                quadToRelative(0.583f, 0.416f, 0.895f, 1.062f)
                quadToRelative(0.313f, 0.646f, 0.313f, 1.354f)
                verticalLineTo(32f)
                quadToRelative(0f, 1.25f, -0.896f, 2.146f)
                quadToRelative(-0.896f, 0.896f, -2.146f, 0.896f)
                horizontalLineToRelative(-6.875f)
                verticalLineTo(23.125f)
                horizontalLineToRelative(-6.916f)
                verticalLineToRelative(11.917f)
                close()
            }
        }
    }



