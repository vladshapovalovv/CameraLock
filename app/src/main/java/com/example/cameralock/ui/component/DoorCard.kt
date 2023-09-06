package com.example.cameralock.ui.component

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cameralock.domain.entity.Door
import com.example.cameralock.ui.theme.cardCollapsedBackgroundColor
import com.example.cameralock.ui.theme.cardExpandedBackgroundColor
import kotlin.math.roundToInt

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun DoorCard(
    door: Door,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier){
        Box {
            Column {
                if (!door.snapshot.isNullOrBlank()) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp),
                        model = door.snapshot,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = door.name,
                        fontSize = 17.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Lock(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(25.dp)
                    )
                }
            }
        }
    }
}
