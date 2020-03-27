package com.example.demomangesh

import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {
    private val contactRepository = ContactRepository()
    var listLiveData = contactRepository.contactList
    fun insert(todo: Todo?) {
        contactRepository.insert(todo!!)
    }

    fun update(todo: Todo) {
        contactRepository.update(todo)
    }

    val data: Unit
        get() {
            contactRepository.data
        }

    fun delete(todo: Todo) {
        contactRepository.delete(todo)
    }
}