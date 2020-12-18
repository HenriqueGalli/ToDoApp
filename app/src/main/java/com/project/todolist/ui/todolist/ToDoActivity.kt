package com.project.todolist.ui.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.todolist.R
import com.project.todolist.base.BaseActivity
import com.project.todolist.data.db.ToDoDatabase
import com.project.todolist.data.repositories.ToDoRepository
import com.project.todolist.other.ToDoItemAdapter
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.toolbar.*

class ToDoActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val database = ToDoDatabase(this)
        val repository = ToDoRepository(database)
        val factory = ToDoViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ToDoViewModel::class.java)
        val adapter = ToDoItemAdapter(listOf(),viewModel)

        rvToDoItems.layoutManager = LinearLayoutManager(this)
        rvToDoItems.adapter = adapter

        viewModel.getAllToDoItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            AddToDoItemDialog(this,
                object : AddDialogListener

            )}
    }
}