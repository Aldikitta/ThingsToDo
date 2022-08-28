package com.aldikitta.thingstodo.model

data class ToDoTaskOverallCount(
    val allTaskCount: Int,
    val scheduledTodayTaskCount: Int,
    val scheduledTaskCount: Int,
)