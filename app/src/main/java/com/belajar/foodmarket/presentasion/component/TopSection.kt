package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.presentasion.ui.theme.Shapes

@Composable
fun TopSection(title: String, subtitle: String) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.onPrimary,
        title = {
            Column(Modifier.padding(start = 5.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontSize = 22.sp)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
                    color = Manatee
                )
            }
        },
        modifier = Modifier.height(100.dp)
    )
}

@Composable
fun TopSection(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconOnClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = iconOnClick, modifier = Modifier.padding(start = 5.dp)) {
                Icon(imageVector = icon, contentDescription = "Navigation")
            }
        },
        title = {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontSize = 22.sp)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
                    color = Manatee
                )
            }
        },
        modifier = Modifier.height(100.dp)
    )
}

@Composable
fun TopSection(
    title: String,
    subtitle: String,
    image: Int,
    imageOnClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.onPrimary,
        actions = {
            Card(
                shape = Shapes.medium,
                backgroundColor = Color.LightGray,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(50.dp)
                    .clickable { imageOnClick() }
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
            }
        },
        title = {
            Column(Modifier.padding(start = 5.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6.copy(fontSize = 22.sp)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
                    color = Manatee
                )
            }
        },
        modifier = Modifier.height(100.dp)
    )
}

@Preview
@Composable
private fun PreviewTopSection() {
    TopSection(title = "Sign In", subtitle = "Find your best ever meal")
}

@Preview
@Composable
private fun PreviewTopSectionIcon() {
    TopSection(
        title = "Sign In",
        subtitle = "Find your best ever meal",
        icon = Icons.Default.ArrowBackIos,
        iconOnClick = {}
    )
}

@Preview
@Composable
private fun PreviewTopSectionImage() {
    TopSection(
        title = "Sign In",
        subtitle = "Find your best ever meal",
        image = R.drawable.audrey_fretz_kyuityoae9m_unsplash,
        imageOnClick = {}
    )
}