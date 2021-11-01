package com.belajar.foodmarket.presentasion.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.presentasion.ui.theme.Shapes
import com.belajar.foodmarket.presentasion.ui.theme.Teal200

@SuppressLint("ModifierParameter")
@Composable
fun OutlinedTextFieldCustom(
    textState: String,
    text: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLine: Int = 1,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    onClearClick: () -> Unit = {}
) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val icon = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff

    Column {
        Text(text = text, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = textState,
            onValueChange = { onValueChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            placeholder = { Text(text = placeholder, style = MaterialTheme.typography.body2) },
            shape = Shapes.medium,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                placeholderColor = Manatee,
                focusedBorderColor = Teal200,
                unfocusedBorderColor = MaterialTheme.colors.onSurface,
            ),
            trailingIcon = {
                if (keyboardType == KeyboardType.Password)
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = icon, contentDescription = "visibility")
                    }
                else
                    IconButton(onClick = { onClearClick() }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                    }
            },
            visualTransformation = if (passwordVisibility || keyboardType != KeyboardType.Password) VisualTransformation.None else PasswordVisualTransformation(),
            maxLines = maxLine,
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun OutlineTextFieldPreview() {
    OutlinedTextFieldCustom(
        "Hallo",
        text = "Coba Aja ini",
        onValueChange = {},
        onClearClick = {},
        placeholder = "Hallo"
    )
}