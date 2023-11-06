package ru.sr.erudite.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import ru.sr.erudite.theme.EruditeTheme

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    shape: Shape = EruditeTheme.shapes.small,
    iconId: Int,
    textButton: String,
    onClick: () -> Unit,
) {

    OutlinedButton(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Unspecified,
        ),
        onClick = onClick
    ) {
        Icon(painter = painterResource(id = iconId), contentDescription = "")
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = textButton,
        )

    }
}