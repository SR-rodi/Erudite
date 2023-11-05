package ru.sr.erudite.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import ru.sr.erudite.presentation.navigation.navGraph.authNavGraph

fun NavGraphBuilder.setNavGraph(navController: NavController) {
    authNavGraph(navController)
}