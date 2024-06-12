package presentation.screens.main

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import domain.model.Course
import presentation.Screens
import presentation.courseBundleKey
import presentation.screens.courses.CoursesScreen
import presentation.screens.details.CourseDetailsView
import presentation.screens.home.BottomNavigationBar
import presentation.screens.home.ProfileView
import presentation.screens.home.ReelsView

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHostMain(
        navController = navController,
        /*

        onNavigate = { routeName ->
            navigateTo(routeName, navController)
        }

         */
    )
}


@Composable
fun NavHostMain(
    navController: NavHostController = rememberNavController(),
    //onNavigate: (rootName: String) -> Unit,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination

    Scaffold(
        /*topBar = {
            val title = getTitle(currentScreen)
            TopBar(
                title = title,
                canNavigateBack = currentScreen?.route == AppScreen.Detail.route,
                navigateUp = { navController.navigateUp() }
            )
        },*/
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Courses(),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            }
        ) {
            composable(route = Screens.Courses()) {
                CoursesScreen(onNavigate = {
                    navController.navigate(Screens.CourseDetails.withObject(it))
                })

            }
            composable(route = Screens.Profile()) {
                ReelsView {
                }
            }
            composable(route = Screens.Setting()) {
                ProfileView {
                }
            }
            composable(route = Screens.CourseDetails()) {
                val course = Screens.CourseDetails.getObject<Course>(courseBundleKey, it.arguments)
                CourseDetailsView(course) {
                    navController.popBackStack()
                }
            }
        }
    }
}



