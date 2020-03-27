package com.example.demomangesh

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_fill_info.*

class FillInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_info)

        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        btn_add.setOnClickListener {
            val name = et_name.text.toString().trim()
            val des = et_desc.text.toString().trim()

            val todo = Todo()
            todo.name = name
            todo.description = des
            contactViewModel.insert(todo)
            finish()
        }
    }
}