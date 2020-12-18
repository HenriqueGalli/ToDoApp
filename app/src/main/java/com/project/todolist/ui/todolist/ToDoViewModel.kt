package com.project.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import com.project.todolist.data.db.entities.ToDoItem
import com.project.todolist.data.repositories.ToDoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoRepository) : ViewModel(){
    fun upsert(item: ToDoItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: ToDoItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllToDoItems() = repository.getAllToDoItems()

}