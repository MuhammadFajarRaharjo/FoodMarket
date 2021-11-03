package com.belajar.foodmarket.presentasion.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.belajar.foodmarket.presentasion.ui.theme.FoodMarketTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun TabPagerHorizontal(
    pagerState: PagerState,
    list: List<String>,
    paddingIndicator: PaddingValues,
    content: @Composable (Int) -> Unit
) {
    val scope = rememberCoroutineScope()
    TabRow(
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
fun PreviewTabPagerHorizontal() {
    FoodMarketTheme {
        Surface {
            TabPagerHorizontal(
                rememberPagerState(),
                listOf("satu", "dua"),
                paddingIndicator = PaddingValues(horizontal = 50.dp)
            ) { }
        }
    }
}