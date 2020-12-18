package com.project.todolist.data.db.entities

import android.accounts.AuthenticatorDescription
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDo_items")
data class ToDoItem (
    @ColumnInfo(name = "task_name")
    var task: String,
    @ColumnInfo(name = "task_description")
    var description: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}