package com.example.demomangesh

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.demomangesh.DataBaseHelper.Companion.getInstance

class ContactRepository {

    private val contactDao: ContactDao
    @JvmField
    var contactList = MutableLiveData<List<Todo>>()
    fun insert(todo: Todo) {
        Log.d(TAG, "insert: $todo")
        Thread(Runnable {
            contactDao.insertTask(todo)
            contactList.postValue(contactDao.getTodoList())
        }).start()
    }

    fun update(todo: Todo) {
        Thread(Runnable {
            contactDao.update(todo)
            contactList.postValue(contactDao.getTodoList())
        }).start()
    }

    val data: Unit
        get() {
            Thread(Runnable { contactList.postValue(contactDao.getTodoList()) }).start()
        }

    fun delete(todo: Todo) {
        Thread(Runnable { contactDao.delete(todo) }).start()
    }

    companion object {
        private const val TAG = "ContactRepository"
    }

    init {
        contactDao = getInstance(DemoApplication.applicationContext())!!.contactDatabase.contactDao()
        Thread(Runnable { contactList.postValue(contactDao.getTodoList()) }).start()
    }
}