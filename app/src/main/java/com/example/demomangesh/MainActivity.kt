package com.example.demomangesh

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var contactAdapter: ContactAdapter? = null
    private  lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_contactList.layoutManager = LinearLayoutManager(this)
        if (contactAdapter == null) {
            contactAdapter = ContactAdapter(this)
            rv_contactList.adapter = contactAdapter
        }
        fab.setOnClickListener { startActivity(Intent(this@MainActivity, FillInfoActivity::class.java)) }
        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)


        contactViewModel.listLiveData.observe(this, Observer {
            if (contactAdapter != null) {
                contactAdapter!!.updateList(it)
            }
        })

    }

    override fun onResume() {
        super.onResume()
        contactViewModel.data
    }
}