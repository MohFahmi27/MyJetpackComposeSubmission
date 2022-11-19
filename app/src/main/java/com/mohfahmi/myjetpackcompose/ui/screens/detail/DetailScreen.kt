package com.mohfahmi.myjetpackcompose.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mohfahmi.myjetpackcompose.data.NewsRepository
import com.mohfahmi.myjetpackcompose.ui.components.MyTopAppBar
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme
import com.mohfahmi.myjetpackcompose.ui.utils.ViewModelFactory

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    idNews: String,
    navigateUp: () -> Unit,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            NewsRepository(),
        ),
    ),
) {
    val newsData by viewModel.getNewsData(idNews).collectAsState()

    Scaffold(
        topBar = {
            MyTopAppBar(
                actions = {
                    navigateUp()
                },
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = newsData.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
            )
            Spacer(modifier = Modifier.padding(14.dp))
            Text(
                text = newsData.headline.uppercase(),
                style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Divider(color = MaterialTheme.colors.onBackground, thickness = 1.dp)
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = newsData.content,
                lineHeight = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .alpha(0.7f)
            )
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }

}

@Preview
@Composable
fun DetailScreenPreview() {
    MyJetpackComposeTheme {
        DetailScreen(idNews = "01", navigateUp = { })
    }
}