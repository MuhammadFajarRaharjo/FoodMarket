package com.belajar.foodmarket.presentasion.main.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee

@Composable
fun SuccessOrder(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_success_order),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.success_order),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Normal),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.subtitle_success_order),
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
            color = Manatee,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))
        // Button to home
        ButtonCustom(
            text = stringResource(id = R.string.order_other_foods),
            modifier = Modifier.fillMaxWidth(0.6f),
            onClick = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(12.dp))
        // Button to order
        ButtonCustom(
            text = stringResource(id = R.string.view_my_order),
            modifier = Modifier.fillMaxWidth(0.6f),
            backgroundColor = Manatee,
            textColor = Color.White,
            onClick = { navController.popBackStack(Screen.Order.route, false) }
        )
    }
}

@Preview
@Composable
private fun PreviewSuccessOrder() {
    FoodMarketTheme {
        Surface {
            SuccessOrder(rememberNavController())
        }
    }
}