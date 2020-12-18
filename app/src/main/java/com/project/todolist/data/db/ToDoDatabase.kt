package com.project.todolist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.todolist.data.db.entities.ToDoItem

@Database(
    entities = [ToDoItem::class],

    version = 1
)
abstract class ToDoDatabase:RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao

    companion object{
        @Volatile
        private var instance: ToDoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatbase(context).also{ instance = it}
        }

        private fun createDatbase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ToDoDatabase::class.java,
                "ToDoDB.db").build()
    }
}