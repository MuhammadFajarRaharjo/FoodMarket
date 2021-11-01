package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.presentasion.ui.theme.Supernova

@Composable
fun RatingStar(rating: Int, modifier: Modifier = Modifier, size: Dp = 16.dp) {
    val ratingState by rememberSaveable() { mutableStateOf(rating) }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        repeat(5) {
            Icon(
                imageVector = Icons.Default.StarRate,
                contentDescription = "rate",
                tint = if (ratingState > it) Supernova else Color.LightGray,
                modifier = Modifier.size(size)
            )
        }
    }
}