package ru.sr.erudite.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import ru.sr.erudite.theme.EruditeTheme
import ru.sr.erudite.uiKit.R

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean = false,
    isEnable: Boolean = true,
    padding: PaddingValues = PaddingValues(),
    onValueChange: (String) -> Unit,
) {

    var isVisibilityPassword by remember { mutableStateOf(false) }

    BaseInputText(
        modifier = modifier,
        value = value,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        paddingValues = padding,
        visualTransformation = if (isVisibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
        hint = stringResource(id = R.string.ui_kit_hint_Password),
        trailingIcon = Icons.Default.Face,
        onClickTrailingIcon = { isVisibilityPassword = !isVisibilityPassword },
        isEnable = isEnable,
        isError = isError,
        supportingText = stringResource(id = R.string.ui_kit_password_helper_error),
        onValueChange = onValueChange
    )
}

@Preview
@Composable
private fun PasswordInputPreview() {
    EruditeTheme {
        PasswordInput(value = "Yesy", onValueChange = {})
    }
}