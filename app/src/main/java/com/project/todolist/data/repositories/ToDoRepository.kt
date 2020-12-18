package com.project.todolist.data.repositories

import com.project.todolist.data.db.ToDoDatabase
import com.project.todolist.data.db.entities.ToDoItem

class ToDoRepository (
    private val db:ToDoDatabase
){
    suspend fun upsert(item: ToDoItem) = db.getToDoDao().upsert(item)

    suspend fun delete(item: ToDoItem) = db.getToDoDao().delete(item)

    fun getAllToDoItems() = db.getToDoDao().getAllToDoItems()
}