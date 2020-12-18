package com.project.todolist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.todolist.data.db.entities.ToDoItem

@Dao
interface ToDoDao {
    //mistura de update e insert. Se não existir ele insere, se ja existir atualiza
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ToDoItem)

    @Delete
    suspend fun delete(item: ToDoItem)

    @Query(value = "SELECT * FROM toDo_items")
    fun getAllToDoItems(): LiveData<List<ToDoItem>>
}