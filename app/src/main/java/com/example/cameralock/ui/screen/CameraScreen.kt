package com.example.cameralock.ui.screen

import androidx.compose.foundation.layout.Arrangement
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
import com.example.cameralock.domain.entity.Camera
import com.example.cameralock.presentation.CameraViewModel
import com.example.cameralock.ui.component.CameraCard
import com.example.cameralock.ui.component.InfoMessage
import com.example.cameralock.ui.component.ProgressBar
import com.example.cameralock.util.PerformOnLifecycle

@Composable
fun CameraScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    viewModel: CameraViewModel = hiltViewModel()
) {

    val cameraState by viewModel.state.observeAsState()

    PerformOnLifecycle(lifecycleOwner = lifecycleOwner, onStart = {
        viewModel.loadCameras()
    })


    cameraState?.onLoading { ProgressBar() }

    cameraState?.onContent { CameraColumn(cameras = it) }

    cameraState?.onError { InfoMessage(msg = it) }


}

@Composable
private fun CameraColumn(cameras: List<Camera>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = cameras, key = { camera -> camera.hashCode() }) { camera ->
            CameraCard(camera = camera)
        }
    }
}



