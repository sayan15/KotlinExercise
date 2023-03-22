package com.example.loginapp

import android.content.Context
import android.content.DialogInterface
import android.icu.text.LocaleDisplayNames.DialectHandling
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewUsers : AppCompatActivity(),CustomAdapter.onItemClickListner {



    lateinit var adapter:CustomAdapter
    lateinit var data:MutableList<UsersList>
    val db=DbHelper(this)
    var usertype:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_users)
        val listView = findViewById<RecyclerView>(R.id.CustomRecycleView)
        val layoutMager= LinearLayoutManager(this)
        val prefs=getSharedPreferences("Myapp", Context.MODE_PRIVATE)
        usertype=prefs.getString("UserType","new user")

        data = db.readAll()

        adapter = CustomAdapter(data,this)

        listView.adapter=adapter
        listView.layoutManager=layoutMager

    }

    override fun onClickListner(position: Int) {

        var clickedItem:UsersList=data[position]
        if(usertype=="admin")
        {
            var alert:AlertDialog.Builder=AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Are you sure to delete ${clickedItem.username.toString()}")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    if(db.deleteCustomer(clickedItem.userId))
                    {
                        clickedItem=data.removeAt(position)
                        adapter.notifyItemRemoved(position)
                        adapter.notifyItemRangeChanged(position,adapter.itemCount)
                        Toast.makeText(this,"Successfully delted",Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this,"Error in deleting",Toast.LENGTH_SHORT).show()
                    }

                })
                .setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

                })
            alert.show()
        }
        else{
            Toast.makeText(this,"Sorry you are restricted to do this",Toast.LENGTH_SHORT).show()
        }


    }
}