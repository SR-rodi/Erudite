package ru.sr.erudite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import ru.sr.erudite.navigation.navGraph.authNavGraph

fun NavGraphBuilder.setNavGraph(navController: NavController) {
    authNavGraph(navController)
}