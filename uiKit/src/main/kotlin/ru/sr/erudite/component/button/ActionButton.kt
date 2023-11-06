package ru.sr.erudite.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import ru.sr.erudite.theme.EruditeTheme

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    shape: Shape = EruditeTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = EruditeTheme.colors.iris100
    ),
    textButton: String,
    onClick: () -> Unit,

    ) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 15.dp),
        shape = shape,
        colors = colors,
        onClick = onClick
    ) {
        Text(text = textButton)
    }
}