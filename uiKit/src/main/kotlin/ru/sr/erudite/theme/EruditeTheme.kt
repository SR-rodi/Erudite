package ru.sr.erudite.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun EruditeTheme(
    isNightMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme{

        val colors = if (isNightMode) darkPalette else lightPalette

        CompositionLocalProvider(
            LocalColorProvider provides colors,
            LocalFontProvider provides EruditeFont,
            LocalShapeProvider provides EruditeShape,
            content = content
        )
    }
}

object EruditeTheme{
    val colors: EruditeColor
        @Composable
        get() = LocalColorProvider.current
    val shapes: EruditeShape
        @Composable
        get() = LocalShapeProvider.current
    val fonts: EruditeFont
        @Composable
        get() = LocalFontProvider.current
}