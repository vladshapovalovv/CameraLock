package com.example.cameralock.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.example.cameralock.domain.entity.Door
import com.example.cameralock.presentation.DoorViewModel
import com.example.cameralock.ui.component.DoorCard
import com.example.cameralock.ui.component.InfoMessage
import com.example.cameralock.ui.component.ProgressBar
import com.example.cameralock.util.PerformOnLifecycle


@Composable
fun DoorScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    viewModel: DoorViewModel = hiltViewModel()
) {

    val doorState by viewModel.state.observeAsState()

    PerformOnLifecycle(lifecycleOwner = lifecycleOwner, onStart = {
        viewModel.loadDoors()
    })

    doorState?.onLoading { ProgressBar() }

    doorState?.onContent { DoorColumn(doors = it) }

    doorState?.onError { InfoMessage(msg = it) }


}

@Composable
private fun DoorColumn(doors: List<Door>, modifier: Modifier = Modifier) {

    Box {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(items = doors, key = { door -> door.hashCode() }) { door ->
                DoorCard(door = door)
            }
        }
    }
}

