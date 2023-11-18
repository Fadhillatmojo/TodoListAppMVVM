package com.example.todolistappmvvm.view.screens.todoList

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoListScreen(todoViewModel: TodoViewModel = viewModel()) {
    if (todoViewModel.getAllToDoList().isEmpty())
        Text(
            text = "Nothing Here ",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxHeight()
        )
    else {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(todoViewModel.getAllToDoList().size) { index ->
                val toDoItem = todoViewModel.getAllToDoList()[index]
                Log.e("_todoList", "" + toDoItem.isComplete)
                Card(
                    backgroundColor = Color.Cyan,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 1.dp,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                    ) {
                        Text(
                            toDoItem.task,
                            textDecoration =
                            if (toDoItem.isComplete) {
                                TextDecoration.LineThrough
                            } else {
                                TextDecoration.None
                            }
                        )
                        Spacer(modifier = Modifier.fillMaxSize(0.7f))
                        Checkbox(
                            checked = toDoItem.isComplete,
                            onCheckedChange = { value ->
                                todoViewModel.markAsComplete(
                                    todoItem = toDoItem,
                                    value = !value,
                                )
                            },
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Delete",
                            modifier = Modifier.clickable {
                                todoViewModel.removeTodoItem(toDoItem)
                            },
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}

