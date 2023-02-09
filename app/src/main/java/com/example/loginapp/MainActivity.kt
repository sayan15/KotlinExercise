package com.example.loginapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val v_UserName:String?="Sayan"
    val v_Password:String?="Sayan"
    var v_textUserName:EditText?=null
    var v_textPassword:EditText?=null
    var v_BtnLogin:Button?=null
    var v_TextView:TextView?=null
    var v_OutputText:String?=null
    var v_TextViewColor:String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        v_textUserName=findViewById(R.id.edtUserName)
        v_textPassword=findViewById(R.id.edtPassword)
        v_BtnLogin=findViewById<Button>(R.id.button)
        v_TextView=findViewById<TextView>(R.id.outputTextView)

        v_BtnLogin!!.setOnClickListener {
            if (v_textUserName!!.text.trim().toString().equals(v_UserName))
            {
                if(v_textPassword!!.text.trim().toString().equals(v_Password))
                {
                    v_OutputText="Welcome "+v_textUserName!!.text.trim().toString()
                    v_TextViewColor="#00FF00"
                }
                else{
                    v_OutputText="Please check your password"
                    v_TextViewColor="#FF0000"
                }
            }
            else{
                v_OutputText="User not exist"
                v_TextViewColor="#FF0000"
            }
            v_TextView!!.setText(v_OutputText)
            v_TextView!!.setTextColor(Color.parseColor(v_TextViewColor))
        }
    }
}