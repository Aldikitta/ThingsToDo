package com.aldikitta.thingstodo.features.dashboard.repository

import com.aldikitta.thingstodo.model.ToDoTaskDiff
import com.aldikitta.thingstodo.model.User
import kotlinx.coroutines.flow.Flow

interface DashboardEnvironmentRepository {
    fun getUser(): Flow<User>
    fun listenToDoTaskDiff(): Flow<ToDoTaskDiff>
}