package com.example.todolistappmvvm.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.todolistappmvvm.components.FullScreenDialog
import com.example.todolistappmvvm.view.screens.todoList.TodoListScreen
import com.example.todolistappmvvm.view.screens.todoList.TodoViewModel

@Composable
fun HomeScreens() {
    val openDialog = remember { mutableStateOf(false) }
    val todoViewModel by remember { mutableStateOf(TodoViewModel()) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog.value = true
                },
                modifier = if (openDialog.value) Modifier.alpha(0f) else Modifier // Use Modifier to control visibility
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "TODO item Add"
                )
            }
        },
        topBar = {
            TopAppBar(title = { Text("To do App") })
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(20.dp).fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (openDialog.value) {
                FullScreenDialog(
                    openDialog = openDialog,
                    todoViewModel = todoViewModel
                )
            }
            TodoListScreen(todoViewModel)
        }
    }
}
