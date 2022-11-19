package com.mohfahmi.myjetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mohfahmi.myjetpackcompose.ui.screens.about.AboutScreen
import com.mohfahmi.myjetpackcompose.ui.screens.detail.DetailScreen
import com.mohfahmi.myjetpackcompose.ui.screens.home.HomeScreen
import com.mohfahmi.myjetpackcompose.ui.utils.Route

@Composable
fun JetpackComposeApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Home.path,
        modifier = modifier,
    ) {
        composable(Route.Home.path) {
            HomeScreen(
                navigateToAbout = {
                    navHostController.navigate(Route.About.path)
                },
                navigateToDetail = { newsId ->
                    navHostController.navigate(Route.Detail.createRoute(newsId))
                }
            )
        }
        composable(Route.About.path) {
            AboutScreen(
                navigateUp = { navHostController.navigateUp() }
            )
        }
        composable(
            route = Route.Detail.path,
            arguments = listOf(navArgument("newsId") { type = NavType.StringType }),
        ) {
            val id = it.arguments?.getString("newsId") ?: "00"
            DetailScreen(
                idNews = id,
                navigateUp = { navHostController.navigateUp() }
            )
        }
    }
}

