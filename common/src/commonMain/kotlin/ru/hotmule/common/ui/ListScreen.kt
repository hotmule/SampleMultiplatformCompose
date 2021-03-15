package ru.hotmule.common.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.hotmule.common.main.List

@Composable
fun ListScreen(
    todoList: List,
    statusBarHeight: Dp = 0.dp,
    navBarHeight: Dp = 0.dp
) {

    val state by todoList.model

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(56.dp + statusBarHeight),
                title = {
                    Text(
                        modifier = Modifier.padding(top = statusBarHeight),
                        text = "Todo List"
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(82.dp + navBarHeight)
            ) {
                Row(
                    modifier = Modifier.padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp + navBarHeight)
                ) {

                    TextField(
                        value = state.text,
                        onValueChange = todoList::onTextChanged,
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(
                        onClick = todoList::onAddClicked,
                        enabled = state.text.isNotEmpty()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Add task"
                        )
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            if (state.items.isNullOrEmpty()) {
                Text(
                    text = "No data",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.items) { item ->
                    Text(
                        text = item,
                        modifier = Modifier
                            .clickable { todoList.onItemClicked(item) }
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}