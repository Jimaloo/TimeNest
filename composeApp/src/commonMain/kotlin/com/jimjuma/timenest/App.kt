package com.jimjuma.timenest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jimjuma.timenest.screens.editLocation.EditLocationScreen
import com.jimjuma.timenest.screens.home.HomeScreen
import com.jimjuma.timenest.screens.locations.LocationsScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination
@Serializable
object LocationsDestination
@Serializable
object EditLocationDestination


@Composable
fun App() {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
    ) {
        Surface {
            val navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = HomeDestination) {
                composable<HomeDestination> {
                    AnimatedVisibility(visible = true) { // Add custom animation
                        HomeScreen(navigateToDetails = { objectId ->
                            navController.navigate(LocationsDestination)
                        })
                    }
                }
                composable<LocationsDestination> {
                    Crossfade(targetState = true) { // Use crossfade for smooth transition
                        LocationsScreen(
                            navigateToEditScreen = {
                                navController.navigate(EditLocationDestination)
                            }
                        )
                    }
                }
                composable<EditLocationDestination> {
                    AnimatedVisibility(visible = true) {
                        EditLocationScreen(
                            navigateToEditScreen = {
                                navController.navigate(HomeDestination)
                            }
                        )
                    }
                }
            }
        }
    }
}
