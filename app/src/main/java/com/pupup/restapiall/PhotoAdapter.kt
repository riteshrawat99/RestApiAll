package com.pupup.restapiall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(val context: Context, private val photosItem : List<PhotosModel>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userId : TextView = itemView.findViewById(R.id.albumId)
        val photoId : TextView = itemView.findViewById(R.id.textView2)
        val title : TextView = itemView.findViewById(R.id.textView3)
        val thumbail : ImageView = itemView.findViewById(R.id.firstImage)
        val url : ImageView = itemView.findViewById(R.id.secondImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_row_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photosItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val pohotP0 = photosItem[position]
        holder.photoId.text=pohotP0.id.toString()
        holder.userId.text=pohotP0.albumId.toString()
        holder.title.text=pohotP0.title

        Glide.with(context).load(photosItem[position].url).into(holder.thumbail)
        Glide.with(context).load(photosItem[position].thumbnailUrl).into(holder.url)
    }

}