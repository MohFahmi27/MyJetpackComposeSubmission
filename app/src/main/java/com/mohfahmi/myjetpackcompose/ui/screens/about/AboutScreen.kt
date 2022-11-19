package com.mohfahmi.myjetpackcompose.ui.screens.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohfahmi.myjetpackcompose.R
import com.mohfahmi.myjetpackcompose.ui.components.BannerProfile
import com.mohfahmi.myjetpackcompose.ui.components.MyTopAppBar
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
) {
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
            BannerProfile()
            Spacer(modifier = Modifier.padding(24.dp))
            Text(
                text = stringResource(id = R.string.about_me),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = stringResource(id = R.string.about_me_content),
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .alpha(0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    MyJetpackComposeTheme {
        AboutScreen {}
    }
}