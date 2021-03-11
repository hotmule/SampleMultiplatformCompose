package ru.hotmule.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun App(
    statusBarHeight: Dp = 0.dp,
    navBarHeight: Dp = 0.dp
) {

    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.height(56.dp + statusBarHeight),
                    title = {
                        Text(
                            modifier = Modifier.padding(top = statusBarHeight),
                            text = "Top bar"
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.height(56.dp + navBarHeight)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                bottom = navBarHeight
                            ),
                        text = "Bottom bar"
                    )
                }
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = { text = "Hello, ${getPlatformName()}" }) {
                    Text(text)
                }
            }
        }
    }
}
