package com.belajar.foodmarket.presentasion.main.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
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
import com.belajar.foodmarket.presentasion.component.ItemFood
import com.belajar.foodmarket.presentasion.component.TabPagerHorizontal
import com.belajar.foodmarket.presentasion.component.TopSection
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun Order(navController: NavHostController) {
    OrderExist(navController)
}

@Composable
private fun OrderEmpty(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_empty_order),
            contentDescription = "Order Empty"
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.order_empty),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Normal),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.subtitle_order_empty),
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light),
            color = Manatee,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))
        // Button to home
        ButtonCustom(
            text = stringResource(id = R.string.find_foods),
            modifier = Modifier.fillMaxWidth(0.6f),
            onClick = { navController.popBackStack() }
        )
    }
}

@ExperimentalPagerApi
@Composable
private fun OrderExist(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.your_order),
                subtitle = stringResource(id = R.string.subtitle_your_order)
            )
        }
    ) {
        val pagerState = rememberPagerState()
        val list = listOf("In Progress", "Past Orders")

        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(24.dp))

                TabPagerHorizontal(
                    pagerState = pagerState,
                    list = list,
                    paddingIndicator = PaddingValues(horizontal = 50.dp)
                ) { page ->
                    when (page) {
                        0 -> repeat(5) {
                            ItemFood(
                                modifier = Modifier.padding(top = 16.dp),
                                onClick = { navController.navigate(Screen.ProgressOrderDetails.route) },
                                text = "Food No. $it",
                                subtitle = "13 item | IDR: 25.000",
                                image = R.drawable.image_example_food
                            )
                        }
                        1 -> repeat(5) {
                            ItemFood(
                                modifier = Modifier.padding(top = 16.dp),
                                onClick = { navController.navigate(Screen.ProgressOrderDetails.route) },
                                text = "Food No. $it",
                                subtitle = "13 item | IDR: 25.000",
                                image = R.drawable.image_example_food
                            ) {
                                Column(verticalArrangement = Arrangement.Center) {
                                    Text(
                                        text = "Jun 12 14.00",
                                        style = MaterialTheme.typography.overline
                                    )
                                    Text(
                                        text = "Canceled",
                                        style = MaterialTheme.typography.overline,
                                        color = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
private fun PreviewOrder() {
    Order(rememberNavController())
}
