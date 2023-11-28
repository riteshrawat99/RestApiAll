package com.pupup.restapiall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(val context: Context,val commentItem : List<CommentsModel>):RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userId : TextView = itemView.findViewById(R.id.userId)
        val id : TextView = itemView.findViewById(R.id.id)
        val name : TextView = itemView.findViewById(R.id.name)
        val email : TextView = itemView.findViewById(R.id.email)
        val body : TextView = itemView.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_row_desing,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return commentItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userPo = commentItem[position]
        holder.userId.text = userPo.postId.toString()
        holder.id.text=userPo.id.toString()
        holder.name.text=userPo.name
        holder.email.text=userPo.email
        holder.body.text=userPo.body
    }
}