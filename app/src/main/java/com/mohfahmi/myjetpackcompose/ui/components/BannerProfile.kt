package com.mohfahmi.myjetpackcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mohfahmi.myjetpackcompose.R

@Composable
fun BannerProfile(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.blob_background),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .sizeIn(minHeight = 350.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 80f, bottomStart = 80f)))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = stringResource(id = R.string.profile),
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Text(
                text = "Mohammad Fahmi".uppercase(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "mohammadfahmi417@gmail.com",
                color = Color.White,
            )
        }
    }
}