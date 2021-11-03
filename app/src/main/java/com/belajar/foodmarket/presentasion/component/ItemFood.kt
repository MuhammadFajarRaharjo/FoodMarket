package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.foodmarket.presentasion.ui.theme.Shapes

@Composable
fun ItemFood(modifier: Modifier = Modifier, image: Int, text: String, subtitle: String, onClick: () -> Unit, content: @Composable () -> Unit = {}) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Card(
            modifier = Modifier
                .size(60.dp)
                .clickable { onClick() },
            backgroundColor = Color.LightGray,
            shape = Shapes.medium,
            elevation = 0.dp
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Image food",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier
            .weight(1f)
            .clickable { onClick() }) {
            Text(text = text, style = MaterialTheme.typography.body1)
            Text(
                text = subtitle,
                style = MaterialTheme.typography.caption.copy(fontSize = 13.sp),
                color = Color.LightGray
            )
        }
        content()
    }
}