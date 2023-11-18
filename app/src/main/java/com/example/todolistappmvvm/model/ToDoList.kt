package com.example.todolistappmvvm.model

data class ToDoList(
    val id:String,
    val task:String,
    var isComplete:Boolean
)
