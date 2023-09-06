package com.example.cameralock.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cameralock.R
import com.example.cameralock.ui.theme.StarColor

@Composable
fun Star(
    modifier: Modifier = Modifier,
    size: Dp = 20.dp,
    filled: Boolean = false
) {
    if (filled) {
        Icon(
            modifier = modifier.size(size),
            painter = painterResource(id = R.drawable.star_filled), contentDescription = null,
            tint = StarColor
        )
    } else {
        Icon(
            modifier = modifier.size(size),
            painter = painterResource(id = R.drawable.star_unfiiled), contentDescription = null,
            tint = StarColor
        )
    }

}