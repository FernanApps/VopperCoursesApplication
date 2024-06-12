package presentation.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import presentation.theme.subTitleTextStyle
import presentation.theme.verticalBackground
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.app_name
import voppercourses.composeapp.generated.resources.author
import voppercourses.composeapp.generated.resources.logo


@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(.75f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.5f,
            animationSpec = tween(
                durationMillis = 1500,
                easing = LinearEasing
            )
        )
        delay(3000L)
        onNavigate()
    }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(verticalBackground)
    ) {
        Spacer(Modifier.weight(1f))
        Spacer(Modifier.size(100.dp))
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = null,
            modifier = Modifier.scale(scale.value).height(45.dp)
        )

        Spacer(Modifier.size(20.dp))

        val normal = SpanStyle(
            fontSize = subTitleTextStyle.fontSize,
        )
        val superscript = SpanStyle(
            baselineShift = BaselineShift.Superscript,
            fontSize = subTitleTextStyle.fontSize.times(0.60f),
        )
        val subscript = SpanStyle(
            baselineShift = BaselineShift.Subscript,
            fontSize = subTitleTextStyle.fontSize.times(0.9f)
        )

        Text(
            text = buildAnnotatedString {
                withStyle(normal) {
                    append(stringResource(Res.string.app_name))
                }
                append("\n")
                withStyle(superscript) {
                    append(stringResource(Res.string.author))
                }
            },
            textAlign = TextAlign.End,
            style = subTitleTextStyle,
            //color = Color(0xFFDBE8D7),
        )
        Spacer(Modifier.weight(1f))

        Row(Modifier.fillMaxWidth()) {
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier.height(5.dp).weight(1f)
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp))
            )
            Spacer(Modifier.weight(1f))

        }


        Spacer(Modifier.height(20.dp))

    }
}

