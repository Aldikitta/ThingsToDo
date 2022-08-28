package com.aldikitta.thingstodo.foundation.datasource.local

import com.aldikitta.thingstodo.foundation.di.DiName
import com.aldikitta.thingstodo.foundation.extension.toDoGroupWithListToGroup
import com.aldikitta.thingstodo.foundation.extension.toDoListWithTasksToToDoList
import com.aldikitta.thingstodo.foundation.extension.toToDoGroup
import com.aldikitta.thingstodo.model.ToDoGroup
import com.aldikitta.thingstodo.model.ToDoList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class LocalManager @Inject constructor(
    @Named(DiName.DISPATCHER_IO) private val dispatcher: CoroutineDispatcher,
    private val toDoReadDao: ToDoReadDao,
    private val toDoWriteDao: ToDoWriteDao
) {
    fun getGroup(): Flow<List<ToDoGroup>> {
        return toDoReadDao.getGroup()
            .filterNotNull()
            .map { it.toToDoGroup() }
            .flowOn(dispatcher)
    }

    fun getGroup(groupId: String): Flow<ToDoGroup> {
        return toDoReadDao.getGroup(groupId)
            .filterNotNull()
            .map { it.toToDoGroup() }
            .flowOn(dispatcher)
    }

    fun getGroupWithList(): Flow<List<ToDoGroup>>{
        return toDoReadDao.getGroupWithList()
            .filterNotNull()
            .map { it.toDoGroupWithListToGroup() }
            .flowOn(dispatcher)
    }

    fun getListWithTasks(): Flow<List<ToDoList>>{
        return toDoReadDao.getListWithTasks()
            .filterNotNull()
            .map { it.toDoListWithTasksToToDoList() }
            .flowOn(dispatcher)
    }

}