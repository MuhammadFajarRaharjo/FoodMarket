package com.belajar.foodmarket.presentasion.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.NavItem
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.main.food.FoodDetail
import com.belajar.foodmarket.presentasion.main.home.Home
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodMarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = {
                            val itemNavigation = listOf(
                                NavItem(Screen.Home.route, R.drawable.ic_home),
                                NavItem(Screen.Order.route, R.drawable.ic_order),
                                NavItem(Screen.Profile.route, R.drawable.ic_profile),
                            )
                            when (navController.currentDestination?.route) {
                                Screen.Order.route,
                                Screen.Profile.route,
                                Screen.Home.route -> {
                                    BottomNavBar(navController, itemNavigation)
                                }
                            }
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.route
                        ) {
                            composable(Screen.Home.route) { Home(navController) }
                            composable(Screen.Order.route) {}
                            composable(Screen.Profile.route) {}
                            composable(Screen.FoodDetail.route) { FoodDetail(navController) }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController, itemNavigation: List<NavItem>) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.onPrimary) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        itemNavigation.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Manatee
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    val itemNavigation = listOf(
        NavItem(Screen.Home.route, R.drawable.ic_home),
        NavItem(Screen.Order.route, R.drawable.ic_order),
        NavItem(Screen.Profile.route, R.drawable.ic_profile),
    )
    BottomNavBar(navController = rememberNavController(), itemNavigation = itemNavigation)
}