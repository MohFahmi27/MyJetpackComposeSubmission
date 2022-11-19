package com.mohfahmi.myjetpackcompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohfahmi.myjetpackcompose.ui.screens.home.components.HomeTopAppBar
import com.mohfahmi.myjetpackcompose.ui.screens.home.components.NewsItem
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopAppBar(
                actions = { },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp),
        ) {
            NewsItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyJetpackComposeTheme {
        HomeScreen()
    }
}