package com.project.todolist.ui.todolist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.project.todolist.data.db.entities.ToDoItem
import kotlinx.android.synthetic.main.dialog_add_todo_item.*

class AddToDoItemDialog(context: Context,var addDialogListener: AddDialogListener): AppCompatDialog(context) {

        override fun onCreate(savedInstanceSatate: Bundle?){
            super.onCreate(savedInstanceSatate)
            tvAdd.setOnClickListener{
                val name = etName.text.toString()
                val description = etDescription.text.toString()

                if(name.isEmpty()){
                    Toast.makeText(context,"Preencher nome da tarefa",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val item = ToDoItem(name, description)
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }

            tvCancel.setOnClickListener{
                cancel()
            }
        }

}