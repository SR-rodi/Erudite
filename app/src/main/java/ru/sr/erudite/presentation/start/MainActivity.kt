package ru.sr.erudite.presentation.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.sr.erudite.DestinationsFlow
import ru.sr.erudite.presentation.navigation.setNavGraph
import ru.sr.erudite.theme.EruditeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EruditeTheme {

                val navController = rememberNavController()

                NavHost(
                    modifier = Modifier
                        .fillMaxSize(),
                    navController = navController,
                    startDestination = DestinationsFlow.DestinationAuth.route,
                ) {
                    setNavGraph(navController)
                }
            }
        }

    }
}