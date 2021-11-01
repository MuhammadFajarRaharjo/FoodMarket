package com.belajar.foodmarket.presentasion.main.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.belajar.foodmarket.R
import com.belajar.foodmarket.presentasion.Screen
import com.belajar.foodmarket.presentasion.component.RatingStar
import com.belajar.foodmarket.presentasion.component.TopSection
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.belajar.foodmarket.presentasion.ui.theme.Manatee
import com.belajar.foodmarket.presentasion.ui.theme.Shapes
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun Home(navController: NavController) {
    Scaffold(
        topBar = {
            TopSection(
                title = stringResource(id = R.string.app_name),
                subtitle = stringResource(id = R.string.subtitle_app_name),
                image = R.drawable.audrey_fretz_kyuityoae9m_unsplash,
                onClick = {}
            )
        }
    ) {
        val pagerState = rememberPagerState()
        val list = listOf("New Taste", "Popular", "Recommended")
        val scope = rememberCoroutineScope()
        val lazyState = rememberLazyListState()

        LazyColumn(state = lazyState, contentPadding = PaddingValues(bottom = 50.dp)) {
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                ) {
                    items(10) { index ->
                        CardFood(
                            rating = index + 1f,
                            modifier = Modifier.padding(
                                start = 24.dp,
                                end = if (index == 9) 24.dp else 0.dp
                            )
                        ) {
                            navController.navigate(Screen.FoodDetail.route)
                        }
                    }
                }
            }
            item {
                ScrollableTabRow(
                    selectedTabIndex = pagerState.currentPage,
                    indicator = { tabPosition ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPosition[pagerState.currentPage])
                                .padding(horizontal = 29.dp)
                                .clip(CircleShape),
                            height = 3.dp
                        )
                    },
                    edgePadding = 11.dp,
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    list.forEachIndexed { index, s ->
                        Tab(
                            selected = pagerState.currentPage == index,
                            onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                            text = { Text(text = s, style = MaterialTheme.typography.button) }
                        )
                    }
                }
            }
            item {
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
                        when (page) {
                            0 -> {
                                repeat(page + 20) {
                                    ItemFood(
                                        rating = page + 1f,
                                        modifier = Modifier.padding(top = 16.dp)
                                    ) {
                                        navController.navigate(Screen.FoodDetail.route)
                                    }
                                }
                            }
                            1 -> {
                                repeat(page + 1) {
                                    ItemFood(
                                        rating = page + 1f,
                                        modifier = Modifier.padding(top = 16.dp)
                                    ) {
                                        navController.navigate(Screen.FoodDetail.route)
                                    }
                                }
                            }
                            2 -> {
                                repeat(page + 1) {
                                    ItemFood(
                                        rating = page + 1f,
                                        modifier = Modifier.padding(top = 16.dp)
                                    ) {
                                        navController.navigate(Screen.FoodDetail.route)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemFood(rating: Float, modifier: Modifier = Modifier, onClick: () -> Unit) {
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
                painter = painterResource(id = R.drawable.image_example_food),
                contentDescription = "Image food",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier
            .weight(1f)
            .clickable { onClick() }) {
            Text(text = "Cherry Healthy", style = MaterialTheme.typography.body1)
            Text(
                text = "IDR 25.000",
                style = MaterialTheme.typography.caption.copy(fontSize = 13.sp),
                color = Color.LightGray
            )
        }
        RatingStar(rating = rating.toInt())
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.caption,
            color = Manatee
        )
    }
}

@Composable
private fun CardFood(rating: Float, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(modifier = modifier.size(200.dp, 210.dp), shape = Shapes.medium) {
        Column(Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.image_example_food),
                contentDescription = "Food",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clickable { onClick() }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Cherry Healthy",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clickable { onClick() }
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                RatingStar(rating = rating.toInt())
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.caption,
                    color = Manatee
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
private fun PreviewHome() {
    FoodMarketTheme {
        Home(navController = rememberNavController())
    }
}