package ru.sr.erudite.navigation.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import ru.sr.erudite.AuthScreen
import ru.sr.erudite.DestinationsFlow
import ru.sr.erudite.navigation.AuthDestinations
import ru.sr.erudite.screen

fun NavGraphBuilder.authNavGraph(navController: NavController) {

    navigation(
        startDestination = AuthDestinations.SignIn.route,
        route = DestinationsFlow.DestinationAuth.route
    ) {

        screen(AuthDestinations.SignIn) {
            AuthScreen()
        }
    }
}