package com.aldikitta.thingstodo.features.dashboard.repository

import com.aldikitta.thingstodo.foundation.datasource.local.LocalManager
import com.aldikitta.thingstodo.foundation.datasource.preferences.PreferenceManager
import com.aldikitta.thingstodo.foundation.wrapper.DateTimeProvider
import com.aldikitta.thingstodo.model.ToDoTaskDiff
import com.aldikitta.thingstodo.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DashboardEnvironmentRepositoryImpl @Inject constructor(
    private val dateTimeProvider: DateTimeProvider,
    private val preferenceManager: PreferenceManager,
    private val localManager: LocalManager,
    private val taskAlarmManager: TaskAlarmManager,
    private val notificationManager: TaskNotificationManager
): DashboardEnvironmentRepository{
    override fun getUser(): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun listenToDoTaskDiff(): Flow<ToDoTaskDiff> {
        TODO("Not yet implemented")
    }
}