package com.example.demomangesh

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}