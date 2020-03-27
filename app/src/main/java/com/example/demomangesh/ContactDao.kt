package com.example.demomangesh

import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    fun insertTask(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getTodoList(): List<Todo>

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}