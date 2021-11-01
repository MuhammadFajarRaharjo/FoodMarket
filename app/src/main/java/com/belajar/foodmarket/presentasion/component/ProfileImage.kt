package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.ui.theme.Manatee

@Composable
fun ProfileImage(modifier: Modifier = Modifier, image: Int?) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ellipse_stroke_dash),
            contentDescription = "Border profile image",
            modifier = Modifier.size(110.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .size(90.dp)
                .background(Color(0XFFF0F0F0))
                .clickable { }
        ) {
            if (image != null) Image(
                painter = painterResource(id = image),
                contentDescription = "Border profile image",
            )
            else Text(
                text = "Add\nPhoto",
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light),
                textAlign = TextAlign.Center,
                color = Manatee
            )
        }
    }
}