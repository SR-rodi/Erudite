package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class EruditeColor (
    val error:Color,
    val text: Color,
    val background:Color,
)


val lightPalette = EruditeColor(
    text = Color(0xFF070707),
    background = Color(0xFFFFE298),
    error = Color(0xFFC00A0A),
)


val darkPalette = lightPalette.copy(background = Color(0xFF202020))

val LocalColorProvider =
    staticCompositionLocalOf<EruditeColor> { error("No default implementation") }