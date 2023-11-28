package com.pupup.restapiall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(val context: Context,val albumsItem : List<AlbumsModel>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
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
      return  albumsItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = albumsItem[position].userId.toString()
        holder.id.text = albumsItem[position].id.toString()
        holder.name.text = albumsItem[position].title
        holder.email.visibility=View.GONE
        holder.body.visibility=View.GONE
    }
}