package com.aldikitta.thingstodo.foundation.datasource.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.aldikitta.thingstodo.foundation.datasource.local.model.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime


/**
 * Return the most recent value for To-Do resource, null if it doesn’t exist.
 */
@Dao
interface ToDoReadDao {
    @Query("SELECT * FROM ToDoGroupDb")
    fun getGroup(): Flow<List<ToDoGroupDb>>

    @Query("SELECT * FROM ToDoGroupDb WHERE group_id = :groupId")
    fun getGroup(groupId: String): Flow<ToDoGroupDb>

    @Query("SELECT * FROM ToDoListDb")
    fun getList(): Flow<List<ToDoListDb>>

    @Query("SELECT * FROM ToDoListDb WHERE list_groupId = 'default' OR list_groupId = :groupId")
    fun getListWithUnGroupList(groupId: String): Flow<List<ToDoListDb>>

    @Query("SELECT * FROM ToDoListDb WHERE list_id = :id")
    fun getListById(id: String): Flow<ToDoListDb>

    @Query("SELECT * FROM ToDoListDb WHERE list_groupId = :groupId")
    fun getListByGroupId(groupId: String): Flow<List<ToDoListDb>>

    @Transaction
    @Query("SELECT * FROM ToDoListDb WHERE list_id = :id")
    fun getListWithTasksById(id: String): Flow<ToDoListWithTasks>

    @Query("SELECT * FROM ToDoTaskDb")
    fun getTask(): Flow<List<ToDoTaskDb>>


    @Transaction
    @Query(
        """
            SELECT *
            FROM ToDoTaskDb 
            LEFT JOIN ToDoListDb ON task_listId = ToDoListDb.list_id
            WHERE task_dueDate IS NOT NULL
            ORDER BY task_dueDate ASC
        """
    )
    fun getTaskWithListOrderByDueDate(): Flow<List<ToDoTaskWithList>>

    @Transaction
    @Query(
        """
            SELECT *
            FROM ToDoTaskDb 
            LEFT JOIN ToDoListDb ON task_listId = ToDoListDb.list_id
            WHERE 
            task_dueDate IS NOT NULL AND 
            task_status != "COMPLETE" AND 
            task_dueDate < :date 
            ORDER BY task_dueDate ASC
        """
    )
    fun getTaskWithListOrderByDueDateToday(date: LocalDateTime): Flow<List<ToDoTaskWithList>>
}