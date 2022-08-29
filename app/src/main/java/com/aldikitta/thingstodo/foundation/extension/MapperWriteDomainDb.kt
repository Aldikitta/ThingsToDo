package com.aldikitta.thingstodo.foundation.extension

import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoGroupDb
import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoListDb
import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoStepDb
import com.aldikitta.thingstodo.foundation.datasource.local.model.ToDoTaskDb
import com.aldikitta.thingstodo.model.*

fun List<ToDoTask>.toTaskDb(listId: String): List<ToDoTaskDb> {
    return map {
        ToDoTaskDb(
            id = it.id,
            name = it.name,
            status = it.status,
            listId = listId,
            dueDate = it.dueDate,
            completedAt = it.completedAt,
            isDueDateTimeSet = it.isDueDateTimeSet,
            repeat = it.repeat,
            note = it.note,
            noteUpdatedAt = it.noteUpdatedAt,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
        )
    }
}

fun List<ToDoStep>.toStepDb(taskId: String): List<ToDoStepDb> {
    return map {
        ToDoStepDb(
            id = it.id,
            name = it.name,
            status = it.status,
            taskId = taskId,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
        )
    }
}

fun List<ToDoGroup>.toGroupDp(): List<ToDoGroupDb> {
    return map {
        ToDoGroupDb(
            id = it.id,
            name = it.name,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
        )
    }
}

fun List<ToDoList>.toListDb(groupId: String): List<ToDoListDb> {
    return map { it.toToDoListDb(groupId) }
}

fun List<GroupIdWithList>.toListDb(): List<ToDoListDb> {
    return map { it.list.toToDoListDb(it.groupId) }
}

private fun ToDoList.toToDoListDb(groupId: String): ToDoListDb {
    return ToDoListDb(
        id = id,
        name = name,
        color = color,
        groupId = groupId,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}