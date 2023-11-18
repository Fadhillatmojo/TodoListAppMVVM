package com.example.todolistappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolistappmvvm.ui.theme.TodoListAppMVVMTheme
import com.example.todolistappmvvm.view.screens.HomeScreens
import com.example.todolistappmvvm.view.screens.todoList.TodoListScreen
import com.example.todolistappmvvm.view.screens.todoList.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreens()
        }
    }
}
