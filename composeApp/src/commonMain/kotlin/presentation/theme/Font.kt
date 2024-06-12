package presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import voppercourses.composeapp.generated.resources.Nunito_Black
import voppercourses.composeapp.generated.resources.Nunito_BlackItalic
import voppercourses.composeapp.generated.resources.Nunito_Bold
import voppercourses.composeapp.generated.resources.Nunito_BoldItalic
import voppercourses.composeapp.generated.resources.Nunito_ExtraBold
import voppercourses.composeapp.generated.resources.Nunito_ExtraBoldItalic
import voppercourses.composeapp.generated.resources.Nunito_ExtraLight
import voppercourses.composeapp.generated.resources.Nunito_ExtraLightItalic
import voppercourses.composeapp.generated.resources.Nunito_Italic
import voppercourses.composeapp.generated.resources.Nunito_Light
import voppercourses.composeapp.generated.resources.Nunito_LightItalic
import voppercourses.composeapp.generated.resources.Nunito_Medium
import voppercourses.composeapp.generated.resources.Nunito_MediumItalic
import voppercourses.composeapp.generated.resources.Nunito_Regular
import voppercourses.composeapp.generated.resources.Nunito_SemiBold
import voppercourses.composeapp.generated.resources.Nunito_SemiBoldItalic
import voppercourses.composeapp.generated.resources.Res

@Composable
fun NunitoFontFamily() = FontFamily(
    Font(Res.font.Nunito_Black, weight = FontWeight.Black, style = FontStyle.Normal),
    Font(Res.font.Nunito_BlackItalic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(Res.font.Nunito_Bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(Res.font.Nunito_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.Nunito_ExtraBold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(Res.font.Nunito_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.Nunito_ExtraLight, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(Res.font.Nunito_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.Nunito_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.Nunito_Light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(Res.font.Nunito_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.Nunito_Medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(Res.font.Nunito_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.Nunito_Regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(Res.font.Nunito_SemiBold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(Res.font.Nunito_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic)
)

@Composable
fun NunitoTypography() = androidx.compose.material3.Typography().run {

    val fontFamily = NunitoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}
