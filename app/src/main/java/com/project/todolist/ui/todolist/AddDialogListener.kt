package com.project.todolist.ui.todolist

import android.os.Bundle
import com.project.todolist.data.db.entities.ToDoItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ToDoItem)
}