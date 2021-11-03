package com.belajar.foodmarket.presentasion.main.order

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.ButtonCustom
import com.belajar.foodmarket.presentasion.component.ItemFood
import com.belajar.foodmarket.presentasion.component.TopSection
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.presentasion.ui.theme.Supernova
import com.belajar.foodmarket.presentasion.ui.theme.Teal200

@Composable
fun FoodOrderDetails(navController: NavHostController) {
    val routeProgressDetails =
        navController.currentDestination?.route == Screen.ProgressOrderDetails.route
    val text = if (routeProgressDetails) R.string.payment else R.string.cancel_may_order

    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.payment),
                subtitle = stringResource(id = R.string.subtitle_payment),
                icon = Icons.Default.ArrowBackIos,
                iconOnClick = { navController.navigateUp() }
            )
        },
        floatingActionButton = {
            ButtonCustom(
                text = stringResource(id = text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 9.dp),
                backgroundColor = if (routeProgressDetails) Color.Red else Supernova,
                textColor = if (routeProgressDetails) Color.White else Color.Black,
                onClick = { navController.navigate(Screen.SuccessOrder.route) }
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            // Item ordered
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onPrimary)
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.item_ordered),
                        style = MaterialTheme.typography.body2
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    ItemFood(
                        onClick = { },
                        text = "Chery Healthy",
                        subtitle = "IDR: 25.000",
                        image = R.drawable.image_example_food
                    ) {
                        Text(
                            text = "14 Items",
                            style = MaterialTheme.typography.caption.copy(fontSize = 13.sp),
                            color = Manatee
                        )
                    }

                    // Details Transaction
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.details_transaction),
                        style = MaterialTheme.typography.body2
                    )
                    // Name and price food
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = "Cherry Healthy",
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "IDR 18.390.000",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // Price driver
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = "Driver",
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "IDR 50.000",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // Tax
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = "Tax 10%",
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "IDR 1.800.390",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // Total price
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = "Total Price",
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "IDR 390.803.000",
                            style = MaterialTheme.typography.body2,
                            color = Teal200
                        )
                    }
                }
            }

            // Destination
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.onPrimary)
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.deliver_to),
                        style = MaterialTheme.typography.body2
                    )

                    // Name
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.name),
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "Muhammad Fajar",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // Phone number
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.phone_number),
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "0877 4117 2090",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // Address
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.address),
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "Kp. Kalapa",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // House number
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.house_number),
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "03",
                            style = MaterialTheme.typography.body2
                        )
                    }

                    // City
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.city),
                            style = MaterialTheme.typography.body2,
                            color = Manatee
                        )
                        Text(
                            text = "Tangerang",
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }

            // Kode item order
            if (routeProgressDetails) {
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.onPrimary)
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.deliver_to),
                            style = MaterialTheme.typography.body2
                        )

                        // Kode and status
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        ) {
                            Text(
                                text = "#1445678",
                                style = MaterialTheme.typography.body2,
                                color = Manatee
                            )
                            Text(
                                text = "Paid",
                                style = MaterialTheme.typography.body2,
                                color = Teal200
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewFoodOrder() {
    FoodMarketTheme {
        FoodOrderDetails(rememberNavController())
    }
}