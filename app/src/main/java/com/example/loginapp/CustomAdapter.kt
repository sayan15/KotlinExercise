package com.example.loginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data:MutableList<UsersList>,
                    private val listner:onItemClickListner
                    ):RecyclerView.Adapter<CustomAdapter.ViewHolder> (){

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userName=view.findViewById<TextView>(R.id.textViewFullName)
        val editBtn=view.findViewById<Button>(R.id.buttonEdit)
        
        init {
            editBtn.setOnClickListener {
                val pos=adapterPosition
                if(pos!=RecyclerView.NO_POSITION){
                    listner.onClickListner(pos)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_users,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.userName.text=data[position].username
        
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface onItemClickListner{
        fun onClickListner(position: Int)
    }

}