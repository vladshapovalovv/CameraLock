package com.example.cameralock.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cameralock.R
import com.example.cameralock.ui.theme.LockColor

@Composable
fun Lock(
    modifier: Modifier = Modifier,
    size: Dp = 20.dp,
) {
    Icon(
        modifier = modifier.size(size),
        painter = painterResource(id = R.drawable.lock), contentDescription = null,
        tint = LockColor
    )
}