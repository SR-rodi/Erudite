package ru.sr.erudite.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sr.erudite.theme.EruditeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseInputText(
    modifier: Modifier = Modifier,
    value: String,
    paddingValues: PaddingValues = PaddingValues(),
    isEnable: Boolean = true,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isSingleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    trailingIcon: ImageVector? = null,
    onClickTrailingIcon: () -> Unit = {},
    supportingText: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    shape: Shape = EruditeTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = EruditeTheme.colors.iris100,
        unfocusedBorderColor = EruditeTheme.colors.textFieldBackground,
        focusedLabelColor = EruditeTheme.colors.iris100,
        cursorColor = EruditeTheme.colors.iris100,
        containerColor = EruditeTheme.colors.textFieldBackground,
        selectionColors = TextSelectionColors(
            handleColor = EruditeTheme.colors.iris100,
            backgroundColor = EruditeTheme.colors.iris100.copy(alpha = 0.35f)
        )
    )
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues),
        value = value,
        onValueChange = onValueChange,
        enabled = isEnable,
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = isSingleLine,
        maxLines = maxLines,
        shape = shape,
        colors = colors,
        label = if (hint == null) {
            null
        } else {
            { Text(text = hint) }
        },
        supportingText = {
            AnimatedVisibility(visible = isError) {
                Text(text = supportingText)
            }
        },
        visualTransformation = visualTransformation,
        trailingIcon = {

            AnimatedVisibility(trailingIcon != null) {
                if (trailingIcon != null)
                    IconButton(onClick = onClickTrailingIcon) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = trailingIcon,
                            contentDescription = null,
                        )
                    }
            }
        },
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun BaseInputTextPreview() {
    EruditeTheme {
        BaseInputText(value = "Test", onValueChange = {})
    }
}