import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope
import presentation.Screens
import presentation.screens.main.MainScreen
import presentation.screens.splash.SplashScreen
import presentation.theme.LocalWindowSizeHeight
import presentation.theme.LocalWindowSizeWidth
import presentation.theme.VopperCoursesTheme
import presentation.theme.WindowSize
import presentation.theme.primaryColor

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
@Preview
fun App() {

    VopperCoursesTheme(seedColor = primaryColor, useDarkTheme = false) {

        val widthSize = when (calculateWindowSizeClass().widthSizeClass) {
            WindowWidthSizeClass.Expanded -> WindowSize.Expanded
            WindowWidthSizeClass.Medium -> WindowSize.Medium
            else -> WindowSize.Compact
        }
        val heightSize = when (calculateWindowSizeClass().heightSizeClass) {
            WindowHeightSizeClass.Expanded -> WindowSize.Expanded
            WindowHeightSizeClass.Medium -> WindowSize.Medium
            else -> WindowSize.Compact
        }

        CompositionLocalProvider(
            //LocalThemeIsDark provides isDarkState,
            LocalWindowSizeWidth provides widthSize,
            LocalWindowSizeHeight provides heightSize
        ) {

            KoinContext {
                val navController: NavHostController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentScreen = Screens.valueOf(
                    backStackEntry?.destination?.route ?: Screens.Splash()
                )

                NavHost(
                    navController = navController,
                    startDestination = Screens.Courses(),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    composable(route = Screens.Splash()) {

                        SplashScreen(
                            onNavigate = {
                                navController.navigate(Screens.Courses())
                            }
                        )
                    }
                    composable(route = Screens.Courses()) {
                        MainScreen()
                    }
                }
            }
        }


    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}


/*var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/