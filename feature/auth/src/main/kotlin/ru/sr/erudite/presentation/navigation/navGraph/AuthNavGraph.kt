package ru.sr.erudite.presentation.navigation.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import ru.sr.erudite.presentation.AuthScreen
import ru.sr.erudite.DestinationsFlow
import ru.sr.erudite.presentation.navigation.AuthDestinations
import ru.sr.erudite.presentation.signIn.SignInScreen
import ru.sr.erudite.screen

fun NavGraphBuilder.authNavGraph(navController: NavController) {

    navigation(
        startDestination = AuthDestinations.SignIn.route,
        route = DestinationsFlow.DestinationAuth.route
    ) {

        screen(AuthDestinations.SignIn) {
            SignInScreen()
        }
    }
}