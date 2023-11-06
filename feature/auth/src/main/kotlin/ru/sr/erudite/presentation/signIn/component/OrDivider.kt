package ru.sr.erudite.presentation.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sr.erudite.theme.EruditeTheme

@Composable
fun OrDivider() {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Gray)
        )
        Text(
            modifier = Modifier.padding(horizontal = 14.dp),
            text = "OR"
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Gray)
        )
    }
}

@Preview
@Composable
private fun OrDividerPreview(){
    EruditeTheme {
        OrDivider()
    }
}