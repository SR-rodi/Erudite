package ru.sr.erudite.presentation.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import ru.sr.erudite.auth.R
import ru.sr.erudite.component.EmailInput
import ru.sr.erudite.component.PasswordInput
import ru.sr.erudite.component.button.ActionButton
import ru.sr.erudite.component.button.SignInButton
import ru.sr.erudite.presentation.signIn.component.OrDivider
import ru.sr.erudite.theme.EruditeTheme

@Composable
fun SignInScreen(
    viewModel: SignInViewModel = koinViewModel()
) {
    SignInContent()

}

@Composable
private fun SignInContent() {

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Log In")
        Spacer(modifier = Modifier.height(24.dp))

        EmailInput(
            value = "Test",
            onClickClearButton = {},
            onValueChange = {})
        Spacer(modifier = Modifier.height(17.dp))
        PasswordInput(
            value = "Test",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(17.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            color = EruditeTheme.colors.iris100,
            text = "Forgot Password?"
        )
        Spacer(modifier = Modifier.height(42.dp))

        ActionButton(
            textButton = "Log In",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(text = "Don’t have an account? ")
            Text(text = "Sign up", color = EruditeTheme.colors.iris100)
        }

        Spacer(modifier = Modifier.height(32.dp))

        OrDivider()

        Spacer(modifier = Modifier.height(16.dp))

        SignInButton(
            iconId = R.drawable.ic_google,
            textButton = "Sign in with Google",
            onClick = {}
        )

        SignInButton(
            iconId = R.drawable.ic_google,
            textButton = "Sign in with VK ID",
            onClick = {}
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