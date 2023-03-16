package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var v_UserExist=false;
    var v_textUserName:EditText?=null
    var v_textPassword:EditText?=null
    var v_BtnLogin:Button?=null
    var v_RegisterBtn:Button?=null
    var v_TextView:TextView?=null
    var v_OutputText:String?=null
    var v_TextViewColor:String?=null
    val db=DbHelper(this)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        v_textUserName=findViewById(R.id.edtUserName)
        v_textPassword=findViewById(R.id.edtPassword)
        v_BtnLogin=findViewById<Button>(R.id.button)
        v_TextView=findViewById<TextView>(R.id.outputTextView)
        v_RegisterBtn=findViewById<Button>(R.id.BtnRegister)


        v_BtnLogin!!.setOnClickListener {
            v_UserExist=db.readPassword(v_textUserName!!.text.trim().toString(),v_textPassword!!.text.trim().toString())

            if (v_UserExist)
            {
                    val prefs=getSharedPreferences("Myapp", Context.MODE_PRIVATE)
                    val editor=prefs.edit()
                    editor.putString("Username",v_textUserName!!.text.toString())
                    editor.apply()
                    val v_NavIntent= Intent(this,Navigation::class.java);
                    startActivity(v_NavIntent)

            }
            else{
                v_OutputText="User not exist"
                v_TextViewColor="#FF0000"
            }
            v_TextView!!.setText(v_OutputText)
            v_TextView!!.setTextColor(Color.parseColor(v_TextViewColor))
        }

        v_RegisterBtn!!.setOnClickListener {
            var v_RegIntent=Intent(this,Register::class.java)
            startActivity(v_RegIntent)
        }
    }
}