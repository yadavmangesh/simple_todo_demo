package com.example.demomangesh

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demomangesh.ContactAdapter.ContactHolder
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter(private val context: Context) : RecyclerView.Adapter<ContactHolder>() {

    private var todoList: List<Todo>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val todo = todoList!![position]
        holder.itemView.tv_name.text = todo.name
        holder.itemView.tv_description.text = todo.description

        holder.itemView.setOnClickListener {
            val intent = Intent(context, EditActivity::class.java)
            intent.putExtra("todo", todo)
            context.startActivity(intent)
        }
    }

    fun updateList(todoList: List<Todo>?) {
        this.todoList = todoList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (todoList == null) 0 else todoList!!.size
    }

    inner class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}