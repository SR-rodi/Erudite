package ru.sr.erudite.presentation.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.sr.erudite.component.EmailInput
import ru.sr.erudite.component.PasswordInput
import ru.sr.erudite.theme.EruditeTheme

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinViewModel()
) {

}

@Composable
private fun SignInContent() {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Log In")
        Spacer(modifier = Modifier.height(24.dp))

        EmailInput(value = "Test", onClickClearButton = {}, onValueChange = {})
        Spacer(modifier = Modifier.height(17.dp))
        PasswordInput(value = "Test", onValueChange = {})
        Spacer(modifier = Modifier.height(17.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = EruditeTheme.colors.iris100,
            text = "Forgot Password?"
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF3EEEE)
@Composable
fun SignInPreview() {
    EruditeTheme {
        SignInContent()
    }
}