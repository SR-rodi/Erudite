package ru.sr.erudite.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class EruditeColor (
    val iris100:Color,
    val textFieldBackground:Color,
    val error:Color,
    val text: Color,
    val background:Color,
)


val lightPalette = EruditeColor(
    text = Color(0xFF070707),
    background = Color(0xFFFFE298),
    error = Color(0xFFC00A0A),
    iris100 = Color(0xFF5D5FEF),
    textFieldBackground = Color(0xFFF1F4FA),
)


val darkPalette = lightPalette.copy(background = Color(0xFF202020))

val LocalColorProvider =
    staticCompositionLocalOf<EruditeColor> { error("No default implementation") }