package com.example.loginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Navigation : AppCompatActivity() {
    var v_buttonCal:Button?=null
    var v_buttonDice:Button?=null
    var v_btnViewUsers:Button?=null
    var v_TextView:TextView?=null
    var v_btnLogout:Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val v_Calintent=Intent(this,Calculator::class.java);
        val v_DiceIntent=Intent(this,DiceGame::class.java);
        val v_ViewUsers=Intent(this,ViewUsers::class.java);
        val v_MainPage=Intent(this,MainActivity::class.java);
        val prefs=getSharedPreferences("Myapp", Context.MODE_PRIVATE)
        val username=prefs.getString("Username","new user")

        v_buttonCal=findViewById<Button>(R.id.button_Calculator)
        v_buttonDice=findViewById<Button>(R.id.button_DiceGame)
        v_btnViewUsers=findViewById<Button>(R.id.button_ViewAllUsers)
        v_TextView=findViewById<TextView>(R.id.textViewWecomeMessage)
        v_btnLogout=findViewById<Button>(R.id.btnLogout)
        v_TextView!!.setText("Welcome "+username.toString())

        v_buttonCal!!.setOnClickListener {

            startActivity(v_Calintent)
        }

        v_buttonDice!!.setOnClickListener {

            startActivity(v_DiceIntent)
        }

        v_btnViewUsers!!.setOnClickListener {
            startActivity(v_ViewUsers)
        }
        v_btnLogout!!.setOnClickListener {
            prefs.edit().remove("Username").commit()
            prefs.edit().remove("UserType").commit()
            startActivity(v_MainPage)
        }
    }
}