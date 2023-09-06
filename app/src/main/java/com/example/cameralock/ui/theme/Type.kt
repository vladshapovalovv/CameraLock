package com.example.cameralock.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cameralock.R

val Circe = FontFamily(
    fonts = listOf(
        Font(R.font.circe, FontWeight.Normal),
    )
)

val Typography = Typography(

    displaySmall = TextStyle(
        fontSize = 21.sp,
        fontFamily = Circe,
        fontWeight = FontWeight.Normal,
        lineHeight = 36.sp,
    ),
    labelLarge = TextStyle(
        fontSize = 17.sp,
        fontFamily = Circe,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontSize = 17.sp,
        fontFamily = Circe,
        fontWeight = FontWeight.Normal,
        lineHeight = 25.sp,
    )
)