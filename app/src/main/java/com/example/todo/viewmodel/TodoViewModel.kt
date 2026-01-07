package com.example.todo.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.model.Todo
import com.example.todo.network.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    var todos: SnapshotStateList<Todo> = mutableStateListOf()
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                val api = TodosApi.getInstance()
                todos.clear()
                todos.addAll(api.getTodos())
            } catch (e: Exception) {
                Log.e("TODO_VIEWMODEL", e.message.toString())
            }
        }
    }
}

