package com.aldikitta.thingstodo.model

data class TaskWithList(
    val list: ToDoList,
    val task: ToDoTask
)