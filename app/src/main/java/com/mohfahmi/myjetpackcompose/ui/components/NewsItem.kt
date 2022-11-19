package com.mohfahmi.myjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
    imgUrl: String,
    id: String,
    title: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .width(160.dp)
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Box(modifier = Modifier
                .weight(1f)) {
                Text(
                    text = id, fontSize = 120.sp, fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .alpha(0.2f)
                        .offset(y = (-17).dp),
                )
                Column(modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .align(Alignment.Center)
                ) {
                    Text(text = title.uppercase(),
                        style = MaterialTheme.typography.h2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth())
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = content,
                        fontSize = 14.sp,
                        maxLines = 3,
                        lineHeight = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(6.dp))
        Divider(color = MaterialTheme.colors.onBackground, thickness = 0.5.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsItemPreview() {
    MyJetpackComposeTheme {
        NewsItem("", "01", "Something", "SOmething gg")
    }
}