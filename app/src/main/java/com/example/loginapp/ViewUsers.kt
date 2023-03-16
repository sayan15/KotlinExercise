package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_users)

        val db=DbHelper(this)
        val listView = findViewById<RecyclerView>(R.id.CustomRecycleView)
        val layoutMager= LinearLayoutManager(this)

        val data = db.readAll() // Replace with your code to retrieve data from table
        val adapter = CustomAdapter(data)
        listView.adapter=adapter
        listView.layoutManager=layoutMager
    }
}