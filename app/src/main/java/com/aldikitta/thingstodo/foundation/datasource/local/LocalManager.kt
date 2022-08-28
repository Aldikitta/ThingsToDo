package com.aldikitta.thingstodo.foundation.datasource.local

import com.aldikitta.thingstodo.foundation.di.DiName
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class LocalManager @Inject constructor(
    @Named(DiName.DISPATCHER_IO) private val dispatcher: CoroutineDispatcher,
    private val toDoReadDao: ToDoReadDao,
    private val toDoWriteDao: ToDoWriteDao
) {
    fun getGroup(): Flow<List<ToDoGr>>
}