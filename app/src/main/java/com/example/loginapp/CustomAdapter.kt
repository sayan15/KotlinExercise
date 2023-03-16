package com.example.loginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data:ArrayList<String>):RecyclerView.Adapter<CustomAdapter.ViewHolder> (){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userName=view.findViewById<TextView>(R.id.textViewFullName)
        val editBtn=view.findViewById<Button>(R.id.buttonEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_users,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.userName.text=data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

}