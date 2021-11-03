package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun ScrollableTabPagerHorizontal(
    pagerState: PagerState,
    list: List<String>,
    paddingIndicator: PaddingValues,
    edgePadding: Dp = TabRowDefaults.ScrollableTabRowPadding,
    content: @Composable (Int) -> Unit
) {
    val scope = rememberCoroutineScope()
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPosition ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset(tabPosition[pagerState.currentPage])
                    .padding(paddingIndicator)
                    .clip(CircleShape),
                height = 3.dp
            )
        },
        edgePadding = edgePadding,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        list.forEachIndexed { index, s ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                text = { Text(text = s, style = MaterialTheme.typography.button) },
            )
        }
    }

    HorizontalPager(
        count = list.size,
        state = pagerState,
        verticalAlignment = Alignment.Top
    ) { page ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        ) {
            content(page)
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
private fun PreviewScrollableTabPagerHorizontal() {
    FoodMarketTheme {
        Surface {
            ScrollableTabPagerHorizontal(
                rememberPagerState(),
                listOf("satu", "dua"),
                paddingIndicator = PaddingValues(horizontal = 50.dp)
            ) { page ->
                when (page) {
                    0 -> repeat(4) {
                        ItemFood(
                            modifier = Modifier.padding(top = 16.dp),
                            onClick = {  },
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
                    1 -> repeat(4) {
                        ItemFood(
                            modifier = Modifier.padding(top = 16.dp),
                            onClick = {  },
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