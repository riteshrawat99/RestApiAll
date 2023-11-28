package com.pupup.restapiall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val context: Context,val userItem : List<UserModelItemItem>):RecyclerView.Adapter<UserAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userId : TextView = itemView.findViewById(R.id.userId1)
        val username : TextView = itemView.findViewById(R.id.userName)
        val userUserName : TextView = itemView.findViewById(R.id.userUserName)
        val userEmail : TextView = itemView.findViewById(R.id.userEmail)
        val userStreet : TextView = itemView.findViewById(R.id.userStreet)
        val usesSuite : TextView = itemView.findViewById(R.id.userSuite)
        val userZip : TextView = itemView.findViewById(R.id.userZipCode)
        val userCite : TextView = itemView.findViewById(R.id.userCity)
        val userlat : TextView = itemView.findViewById(R.id.userlat)
        val userlan : TextView = itemView.findViewById(R.id.userlan)
        val userPhone : TextView = itemView.findViewById(R.id.userPhone)
        val userwebsite : TextView = itemView.findViewById(R.id.userWebsite)
        val userCName : TextView = itemView.findViewById(R.id.userCName)
        val userbs : TextView = itemView.findViewById(R.id.userBs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row_desing,parent,false)
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return userItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val po = userItem[position]

        holder.userId.text=po.id.toString()
        holder.username.text = po.username
        holder.userUserName.text = po.username
        holder.userEmail.text = po.email
        holder.userStreet.text = po.address.street
        holder.usesSuite.text=po.address.suite
        holder.userZip.text=po.address.zipcode
        holder.userCite.text=po.address.city
        holder.userPhone.text=po.phone
        holder.userwebsite.text=po.website
        holder.userCName.text=po.company.name
        holder.userbs.text=po.company.bs
        holder.userlat.text=po.address.geo.lat
        holder.userlan.text=po.address.geo.lng

    }

}