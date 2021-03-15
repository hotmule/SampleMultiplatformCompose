package ru.hotmule.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.hotmule.common.main.Details

@Composable
fun DetailsScreen(
    details: Details,
    statusBarHeight: Dp = 0.dp
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(56.dp + statusBarHeight),
                navigationIcon = {
                    IconButton(
                        onClick = details::onBackClicked,
                        modifier = Modifier.padding(top = statusBarHeight)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.padding(top = statusBarHeight),
                        text = "Details"
                    )
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = details.text,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}