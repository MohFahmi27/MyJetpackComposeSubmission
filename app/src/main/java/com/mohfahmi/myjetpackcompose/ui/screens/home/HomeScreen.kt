package com.mohfahmi.myjetpackcompose.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mohfahmi.myjetpackcompose.data.NewsRepository
import com.mohfahmi.myjetpackcompose.ui.components.HomeTopAppBar
import com.mohfahmi.myjetpackcompose.ui.components.NewsItem
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme
import com.mohfahmi.myjetpackcompose.ui.utils.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(
            NewsRepository(),
        ),
    ),
    navigateToAbout: () -> Unit,
    navigateToDetail: (String) -> Unit,
) {
    val news by viewModel.news.collectAsState()

    Scaffold(
        topBar = {
            HomeTopAppBar(
                actions = {
                    navigateToAbout()
                },
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(news, key = { it.id }) {
                    NewsItem(
                        imgUrl = it.imageUrl,
                        id = it.id,
                        title = it.headline,
                        content = it.content,
                        modifier = Modifier.clickable {
                            navigateToDetail(it.id)
                        },
                    )
                }
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenLightAppPreview() {
    MyJetpackComposeTheme {
        HomeScreen(navigateToAbout = {}, navigateToDetail = {})
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkAppPreview() {
    MyJetpackComposeTheme {
        HomeScreen(navigateToAbout = {}, navigateToDetail = {})
    }
}