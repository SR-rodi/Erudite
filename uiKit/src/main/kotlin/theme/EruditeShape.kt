package theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

object EruditeShape {

    val small = RoundedCornerShape(8.dp)
    val medium = RoundedCornerShape(12.dp)
    val large = RoundedCornerShape(20.dp)
    val dialog = RoundedCornerShape(30.dp)
}

val LocalShapeProvider =
    staticCompositionLocalOf<EruditeShape> { error("No default implementation") }