package com.mohfahmi.myjetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mohfahmi.myjetpackcompose.ui.screens.home.HomeScreen
import com.mohfahmi.myjetpackcompose.ui.theme.MyJetpackComposeTheme

@Composable
fun JetpackComposeApp() {
    HomeScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightAppPreview() {
    MyJetpackComposeTheme {
        JetpackComposeApp()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkAppPreview() {
    MyJetpackComposeTheme {
        JetpackComposeApp()
    }
}

