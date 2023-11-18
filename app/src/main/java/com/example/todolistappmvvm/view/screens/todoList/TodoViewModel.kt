package com.example.todolistappmvvm.view.screens.todoList


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todolistappmvvm.model.ToDoList

class TodoViewModel : ViewModel() {
    private var _todoList = mutableStateListOf<ToDoList>()


    fun getAllToDoList(): List<ToDoList> {
        return _todoList;
    }

    fun addTodoList(todoItem: ToDoList) {
        _todoList.add(todoItem)
    }

    fun removeTodoItem(todoItem: ToDoList) {

        _todoList.remove(todoItem)
    }

    fun markAsComplete(todoItem: ToDoList, value: Boolean) {
        val index = _todoList.indexOf(todoItem);

        _todoList[index] = _todoList[index].let {it->
            it.copy(
                id = it.id,
                task = it.task,
                isComplete = value
            )
        }
    }
}