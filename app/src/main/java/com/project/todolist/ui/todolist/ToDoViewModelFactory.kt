package com.project.todolist.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.todolist.data.repositories.ToDoRepository

class ToDoViewModelFactory
    (private val repository: ToDoRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoViewModel(repository) as T
    }
}