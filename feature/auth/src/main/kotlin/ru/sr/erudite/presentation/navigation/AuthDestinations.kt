package ru.sr.erudite.presentation.navigation

import ru.sr.erudite.Destinations

internal sealed class AuthDestinations(
    override val route: String,
    override val key: String? = null
) : Destinations {
    object SignIn : AuthDestinations(route = "AuthDestinations.SignIn")
}

