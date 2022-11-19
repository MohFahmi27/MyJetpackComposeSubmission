package com.mohfahmi.myjetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mohfahmi.myjetpackcompose.R

val Domine = FontFamily(
    Font(R.font.domine_regular),
    Font(R.font.domine_bold, FontWeight.Bold)
)
val KralaberFraktur = FontFamily(Font(R.font.klaber_fraktur, FontWeight.ExtraBold))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = KralaberFraktur,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = Domine,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = Domine,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)