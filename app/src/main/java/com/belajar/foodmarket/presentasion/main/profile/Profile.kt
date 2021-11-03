package com.belajar.foodmarket.presentasion.main.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.component.ProfileImage
import com.belajar.foodmarket.presentasion.component.TabPagerHorizontal
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun Profile() {
    Column(Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState()
        val list = listOf("Account", "FoodMarket")

        // Header profile
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(top = 46.dp, bottom = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage(image = R.drawable.audrey_fretz_kyuityoae9m_unsplash)

            // Username
            Text(
                text = "Muhammad Fajar",
                style = MaterialTheme.typography.h6.copy(fontSize = 16.sp)
            )
            // Email
            Text(
                text = "fraharjo917@gmail.com",
                style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Light)
            )
        }

        LazyColumn{
            item {
                Spacer(modifier = Modifier.height(24.dp))

                TabPagerHorizontal(
                    pagerState = pagerState,
                    list = list,
                    paddingIndicator = PaddingValues(horizontal = 50.dp)
                ) { page ->
                    Spacer(modifier = Modifier.height(6.dp))
                    when (page) {
                        0 -> repeat(5) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp)
                            ) {
                                Text(text = "Coba $it", style = MaterialTheme.typography.body2)
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowForwardIos,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                        1 -> repeat(5) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp)
                            ) {
                                Text(text = "Coba $it", style = MaterialTheme.typography.body2)
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowForwardIos,
                                        contentDescription = null
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
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
private fun PreviewProfile() {
    FoodMarketTheme {
        Scaffold {
            Profile()
        }
    }
}