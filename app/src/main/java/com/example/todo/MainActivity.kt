package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.ui.TodoList
import com.example.todo.viewmodel.TodoViewModel
import com.example.todo.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                val vm: TodoViewModel = viewModel()
                TodoList(todos = vm.todos)
            }
        }
    }
}
