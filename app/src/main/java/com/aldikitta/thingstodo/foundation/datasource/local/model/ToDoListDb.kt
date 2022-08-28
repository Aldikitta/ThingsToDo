package com.aldikitta.thingstodo.foundation.datasource.local.model

import androidx.room.*
import com.aldikitta.thingstodo.model.ToDoColor
import java.time.LocalDateTime

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ToDoGroupDb::class,
            parentColumns = ["group_id"],
            childColumns = ["list_groupId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("list_groupId"),
        Index("list_name", unique = true)
    ]
)
data class ToDoListDb(
    @PrimaryKey
    @ColumnInfo(name = "list_id")
    val id: String,
    @ColumnInfo(name = "list_name")
    val name: String,
    @ColumnInfo(name = "list_color")
    val color: ToDoColor,
    @ColumnInfo(name = "list_groupId")
    val groupId: String,
    @ColumnInfo(name = "list_createdAt")
    val createdAt: LocalDateTime,
    @ColumnInfo(name = "list_updatedAt")
    val updatedAt: LocalDateTime,
)