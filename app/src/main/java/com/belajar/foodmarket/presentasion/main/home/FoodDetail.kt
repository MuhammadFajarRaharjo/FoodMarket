package com.belajar.foodmarket.presentasion.main.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.component.RatingStar
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.presentasion.ui.theme.Shapes

@Composable
fun FoodDetail(navController: NavHostController) {

    var quantity by rememberSaveable { mutableStateOf(1) }
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {

        // Image Background
        Image(
            painter = painterResource(id = R.drawable.image_example_food),
            contentDescription = "Example food",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .align(Alignment.TopCenter)
        )

        // Button back
        IconButton(
            onClick = { navController.navigateUp() },
            modifier = Modifier.padding(start = 9.dp, top = 15.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = "Back",
                tint = MaterialTheme.colors.surface
            )
        }

        // Content card
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxHeight(0.55f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(MaterialTheme.colors.surface)
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 25.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Cherry Healthy",
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        RatingStar(rating = 3)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "3.0",
                            style = MaterialTheme.typography.caption,
                            color = Manatee
                        )
                    }
                }
                OutlinedButton(
                    onClick = { if (quantity < 1) quantity-- },
                    modifier = Modifier.size(26.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colors.onSurface)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "minus",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Text(
                    text = quantity.toString(),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                OutlinedButton(
                    onClick = { quantity++ },
                    modifier = Modifier.size(26.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colors.onSurface)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "plus",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
            }

            // Description Food
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Makanan khas Bandung yang cukup sering dipesan oleh anak muda dengan pola makan yang cukup tinggi dengan mengutamakan diet yang sehat dan teratur.",
                style = MaterialTheme.typography.subtitle2,
                color = Manatee,
            )

            // Ingredients
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = R.string.ingredients),
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Seledri, telur, blueberry, madu.",
                style = MaterialTheme.typography.subtitle2,
                color = Manatee,
            )

            // Price
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Price",
                        style = MaterialTheme.typography.subtitle2,
                        color = Manatee,
                    )
                    Text(
                        text = "IDR 20.000.000",
                        style = MaterialTheme.typography.body1.copy(fontSize = 18.sp),
                    )
                }
                ButtonCustom(
                    text = stringResource(id = R.string.order_now),
                    shapes = Shapes.large,
                    contentPadding = PaddingValues(vertical = 14.dp, horizontal = 44.dp),
                    onClick = { navController.navigate(Screen.PaymentAndAddressDetails.route)}
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
private fun PreviewFoodDetail() {
    FoodMarketTheme {
        Surface {
            FoodDetail(rememberNavController())
        }
    }
}