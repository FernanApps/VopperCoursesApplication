package presentation.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import domain.repository.AppPreferencesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import presentation.components.IconButtonBack
import presentation.theme.LocalWindowSizeWidth
import presentation.theme.WindowSize
import presentation.theme.subTitleTextStyle
import presentation.theme.verticalBackground
import voppercourses.composeapp.generated.resources.Res
import voppercourses.composeapp.generated.resources.app_name
import voppercourses.composeapp.generated.resources.author
import voppercourses.composeapp.generated.resources.logo
import voppercourses.composeapp.generated.resources.value_empty
import voppercourses.composeapp.generated.resources.value_short
import voppercourses.composeapp.generated.resources.whats_your_name


@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    var userName by remember { mutableStateOf("") }
    var isFinishSplash by remember { mutableStateOf(false) }

    val appPreferencesRepository = koinInject<AppPreferencesRepository>()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        userName = appPreferencesRepository.getUserName()
    }

    if (!isFinishSplash) {
        SplashScreenContentInitial(Modifier.fillMaxSize().background(verticalBackground)) {
            isFinishSplash = true
        }
    } else {
        if (userName.isEmpty()) {
            SplashScreenContentYourName(Modifier.fillMaxSize().background(verticalBackground)) { userNameInput ->
                coroutineScope.launch {
                    appPreferencesRepository.addUserName(userNameInput)
                    onNavigate()
                }
            }
        } else {
            onNavigate()
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreenContentYourName(
    modifier: Modifier = Modifier,
    onNavigate: (userName: String) -> Unit
) {

    var userName by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var errorValue: StringResource? by remember { mutableStateOf(null) }

    val coroutineScope = rememberCoroutineScope()
    var hideErrorJob: Job? by remember { mutableStateOf(null) }

    LaunchedEffect(isError) {
        if (isError) {

            hideErrorJob?.cancel()
            hideErrorJob = coroutineScope.launch {
                delay(1500)
                isError = false
            }
        }
    }

    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val primaryColor = MaterialTheme.colorScheme.primary
        Text(stringResource(Res.string.whats_your_name))
        Spacer(Modifier.size(5.dp))


        val weight = if(LocalWindowSizeWidth.current == WindowSize.Compact){
            0.5f
        } else {
            1f
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {



            Spacer(Modifier.weight(weight))
            OutlinedTextField(
                value = userName,
                onValueChange = {
                    userName = it
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(Icons.Filled.Person, "", tint = primaryColor)
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    errorIndicatorColor = MaterialTheme.colorScheme.error
                    //focusedIndicatorColor = Color.Transparent,
                    //unfocusedIndicatorColor = Color.Gray
                ),
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            text = stringResource(errorValue!!),
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
            )
            Spacer(Modifier.weight(weight))

        }
        IconButtonBack(
            modifier = Modifier.rotate(180F),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            if (userName.isEmpty()) {
                errorValue = Res.string.value_empty
                isError = true
                return@IconButtonBack
            }
            if (userName.length < 3) {
                errorValue = Res.string.value_short
                isError = true
                return@IconButtonBack
            }
            onNavigate(userName)
        }

    }
}

@Composable
fun SplashScreenContentInitial(modifier: Modifier = Modifier, onNavigate: () -> Unit) {
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



    var weightValue by remember { mutableStateOf(1f) }

    val weight by animateFloatAsState(
        targetValue = weightValue,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    var weightValueCount by remember { mutableStateOf(0.1f) }
    val coroutineScope = rememberCoroutineScope()
    DisposableEffect(true){
        val stopJob = coroutineScope.launch {
            while (true){
                delay(400)
                if(weightValue == 1f){
                    val finalWeightValue = weightValue - weightValueCount
                    weightValue = maxOf(0.1f, finalWeightValue)
                    weightValueCount += 0.1f
                } else {
                    weightValue = 1f
                }
            }
        }
        onDispose {
            stopJob.cancel()
        }
    }




    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
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

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier.height(5.dp).weight(weight)
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp))
            )
            Spacer(Modifier.weight(1f))

        }


        Spacer(Modifier.height(20.dp))

    }
}

