package com.example.cameralock.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cameralock.R
import com.example.cameralock.ui.theme.GrayTint
import com.example.cameralock.ui.theme.LockColor

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    selectedColor: Color = LockColor,
    unselectedColor: Color = GrayTint,
    changeSelection: () -> Unit
) {
    Row(modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable { changeSelection() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = stringResource(R.string.cameras),
                style = MaterialTheme.typography.labelLarge
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .clip(CircleShape)
                    .background(color = if (selectedPage == 0) selectedColor else unselectedColor)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable { changeSelection() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = stringResource(R.string.doors),
                style = MaterialTheme.typography.labelLarge
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .clip(CircleShape)
                    .background(color = if (selectedPage == 1) selectedColor else unselectedColor)
            )
        }
    }

}