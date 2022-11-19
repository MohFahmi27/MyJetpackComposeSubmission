package com.mohfahmi.myjetpackcompose.ui.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme

@Composable
fun NewsItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://images.pexels.com/photos/2872418/pexels-photo-2872418.jpeg",
            contentDescription = "news",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(160.dp)
                .height(180.dp)
        )
        Spacer(modifier = Modifier.padding(start = 4.dp))
        Box(modifier = Modifier
            .weight(1f)) {
            Text(
                text = "01", fontSize = 120.sp, fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .alpha(0.2f)
                    .offset(y = (-17).dp),
            )
            Column(modifier = Modifier
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                ) {
                Text(text = "TITLE",
                    style = MaterialTheme.typography.h2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth())
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "Subtitle",
                    fontSize = 14.sp,
                    maxLines = 3,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    MyJetpackComposeTheme {
        NewsItem()
    }
}