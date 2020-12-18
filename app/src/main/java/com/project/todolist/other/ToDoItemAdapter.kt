package com.project.todolist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.project.todolist.R
import com.project.todolist.data.db.entities.ToDoItem
import com.project.todolist.ui.todolist.ToDoViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class ToDoItemAdapter(
    var items: List<ToDoItem>,
    private val viewModel: ToDoViewModel
) :RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val curToDoItem = items[position]

        holder.itemView.tvName.text = curToDoItem.task
        holder.itemView.tvDescription.text = curToDoItem.description

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(curToDoItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}