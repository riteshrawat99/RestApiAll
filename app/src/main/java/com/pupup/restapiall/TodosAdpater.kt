package com.pupup.restapiall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TodosAdpater (val context: Context,private val todosItem:List<TodosModel>) : RecyclerView.Adapter<TodosAdpater.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val userId : TextView = itemView.findViewById(R.id.todosUserId)
        val id : TextView = itemView.findViewById(R.id.todoId)
        val title : TextView = itemView.findViewById(R.id.todoTitle)
        val complete : TextView = itemView.findViewById(R.id.todoComplite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.todos_row_desing,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return todosItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val todosP0 = todosItem[position]
        holder.userId.text=todosP0.userId.toString()
        holder.id.text=todosP0.id.toString()
        holder.title.text=todosP0.title
        holder.complete.text=todosP0.completed

    }

}