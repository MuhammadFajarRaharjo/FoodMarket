package com.belajar.foodmarket.presentasion.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.presentasion.ui.theme.Shapes

@SuppressLint("ModifierParameter")
@Composable
fun ButtonCustom(
    text: String,
    shapes: CornerBasedShape = Shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.primary, modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colors.onSecondary,
    contentPadding: PaddingValues = PaddingValues(vertical = 14.dp),
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        content = { Text(text = text, style = MaterialTheme.typography.button, color = textColor) },
        shape = shapes,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = modifier,
        contentPadding = contentPadding
    )
}