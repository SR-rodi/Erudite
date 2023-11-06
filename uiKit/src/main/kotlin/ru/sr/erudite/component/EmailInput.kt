package ru.sr.erudite.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import ru.sr.erudite.theme.EruditeTheme
import ru.sr.erudite.uiKit.R

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    value: String,
    padding:PaddingValues = PaddingValues(),
    isError: Boolean = false,
    isEnable: Boolean = true,
    isVisibleTrailingIcon: Boolean = true,
    onClickClearButton: () -> Unit,
    onValueChange: (String) -> Unit,
) {

    BaseInputText(
        modifier = modifier,
        value = value,
        isError = isError,
        isEnable = isEnable,
        paddingValues = padding,
        hint = stringResource(id = R.string.ui_kit_hint_email),
        trailingIcon = if (isVisibleTrailingIcon) Icons.Filled.Clear else null,
        supportingText = stringResource(id = R.string.ui_kit_error_email),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
        ),
        onValueChange = onValueChange,
        onClickTrailingIcon = onClickClearButton
    )
}

@Preview
@Composable
private fun EmailInputPreview() {
    EruditeTheme {
        EmailInput(value = "Test", onClickClearButton = { }, onValueChange = {})
    }
}