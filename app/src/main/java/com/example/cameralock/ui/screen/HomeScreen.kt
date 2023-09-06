package com.example.cameralock.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cameralock.R
import com.example.cameralock.ui.component.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .height(55.dp)
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(R.string.my_home),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall
            )
        }

        val pagerState = rememberPagerState(initialPage = 0) { 2 }
        val scope = rememberCoroutineScope()

        PageIndicator(selectedPage = pagerState.currentPage) {
            scope.launch {
                if (pagerState.currentPage == 0) {
                    pagerState.animateScrollToPage(1)
                } else {
                    pagerState.animateScrollToPage(0)
                }
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        HorizontalPager(state = pagerState, userScrollEnabled = false) { index ->
            when (index) {
                0 -> CameraScreen()
                1 -> DoorScreen()
            }
        }

    }
}

