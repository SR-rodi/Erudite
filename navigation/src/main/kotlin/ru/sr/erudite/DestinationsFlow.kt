package ru.sr.erudite

sealed class DestinationsFlow(
    override val route: String,
    override val key: String? = null,
) : Destinations {
    object DestinationAuth : DestinationsFlow(route = "DestinationAuth")
}

interface Destinations {
    val route: String
    val key: String?
}