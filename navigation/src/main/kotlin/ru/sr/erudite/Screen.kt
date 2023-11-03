package ru.sr.erudite

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.screen(destinations: Destinations, content: @Composable () -> Unit) {

    composable(destinations.route) {
        content()
    }
}

fun <T> NavGraphBuilder.screen(
    destinations: Destinations,
    navController: NavController,
    content: @Composable (value: T) -> Unit,
) {

    composable(destinations.route) {
        val key = destinations.key ?: throw NullPointerException("Ключ не задан")
        val value = navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<T>(key)
        if (value == null) Log.e("Kart", "аргумент не задан") else content(value)

    }
}