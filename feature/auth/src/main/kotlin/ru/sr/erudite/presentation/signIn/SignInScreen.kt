package ru.sr.erudite.presentation.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.sr.erudite.auth.R
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

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 15.dp),
            shape = EruditeTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = EruditeTheme.colors.iris100
            ),
            onClick = { /*TODO*/ }) {
            Text(text = "Log In")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(text = "Don’t have an account? ")
            Text(text = "Sign up", color = EruditeTheme.colors.iris100)
        }

        Spacer(modifier = Modifier.height(32.dp))

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

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            modifier =Modifier.fillMaxWidth(),
            shape = EruditeTheme.shapes.small,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor =  Color.Unspecified,
            ),
            onClick = { /*TODO*/ }
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = "")
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = "Sign in with Google",
            )

        }

        OutlinedButton(
            modifier =Modifier.fillMaxWidth(),
            shape = EruditeTheme.shapes.small,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor =  Color.Unspecified,
            ),
            onClick = { /*TODO*/ }
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_google), contentDescription = "")
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = "Sign in with VK ID",
            )

        }


    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF3EEEE)
@Composable
fun SignInPreview() {
    EruditeTheme {
        SignInContent()
    }
}