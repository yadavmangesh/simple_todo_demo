package com.example.demomangesh

import android.content.Context
import androidx.room.Room

class DataBaseHelper private constructor(private val context: Context) {
    val contactDatabase: ContactDatabase

    companion object {
        private var INSTANCE: DataBaseHelper? = null

        @JvmStatic
        @Synchronized
        fun getInstance(ctx: Context): DataBaseHelper? {
            if (INSTANCE == null) {
                INSTANCE = DataBaseHelper(ctx)
            }
            return INSTANCE
        }
    }

    init {
        contactDatabase = Room.databaseBuilder(context, ContactDatabase::class.java, "contactlist").build()
    }
}