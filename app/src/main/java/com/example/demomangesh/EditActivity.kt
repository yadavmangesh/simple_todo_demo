package com.example.demomangesh

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    private var todo: Todo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        if (intent != null) {
            val intent = intent
            if (intent.hasExtra("todo")) {
                todo = intent.getParcelableExtra("todo")
            }
        }

        val editButton = findViewById<MaterialButton>(R.id.btn_update)
        if (todo != null) {
            et_desc.setText(todo?.description)
            et_name.setText(todo?.name)
        }
        tv_delete.setOnClickListener(View.OnClickListener {
            todo?.let { it1 -> contactViewModel.delete(it1) }
            finish()
        })
        editButton.setOnClickListener {
            todo?.name=et_name.text.toString().trim()
            todo?.description=et_desc.text.toString().trim()
            todo?.let { it1 -> contactViewModel.update(it1) }
            finish()
        }
    }
}