package se.android.blibb.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun RegisterTextField(
    modifier: Modifier = Modifier,
    hint: String,
    isError: Boolean,
    supportText: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    label: String,
    trailingIcon: Painter? = null,
    onTrailingIconClick: () -> Unit = {},
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        modifier = modifier,
        label = { Text(text = label) },
        supportingText = {
            if (isError) {
                Text(text = supportText)
            }
        },
        placeholder = {
            Text(text = hint)
        },
        shape = RoundedCornerShape(30f),
        maxLines = 1,
        visualTransformation = visualTransformation,
        trailingIcon = if (trailingIcon == null) null else {
            {
                IconButton(onClick = onTrailingIconClick) {
                    Icon(painter = trailingIcon, contentDescription = "")
                }
            }
        }
    )
}


