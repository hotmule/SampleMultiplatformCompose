package ru.hotmule.common.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import ru.hotmule.common.main.Root

@Composable
fun RootScreen(
    root: Root
) {
    MaterialTheme {
        Children(root.routerState) { child, _ ->
            child()
        }
    }
}
