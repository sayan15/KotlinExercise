package com.example.loginapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup



class Register : AppCompatActivity() {

    var v_textUserName:EditText?=null
    var v_textPassword:EditText?=null
    var v_registerButton:Button?=null
    var v_userType:String?=null
    var db=DbHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        v_textUserName=findViewById<EditText>(R.id.editTextPersonName)
        v_textPassword=findViewById<EditText>(R.id.editTextPassword)
        v_registerButton=findViewById<Button>(R.id.RegisterBtn)



        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupAdmin)
        val radioButton1 = findViewById<RadioButton>(R.id.radio_button1)
        val radioButton2 = findViewById<RadioButton>(R.id.radio_button2)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_button1-> {
                    v_userType="admin"
                }
                R.id.radio_button2 -> {
                    v_userType="user"
                }
            }
        }

        v_registerButton!!.setOnClickListener {
            if(!v_textUserName!!.text.toString().isNullOrEmpty() and !v_textPassword!!.text.toString().isNullOrEmpty() and !v_userType.toString().isNullOrEmpty())
            {
                db.addUser(v_textUserName!!.text.toString(),v_textPassword!!.text.toString(),v_userType.toString())
                var v_LogIntent= Intent(this,MainActivity::class.java)
                v_textPassword!!.text.clear()
                v_textPassword!!.text.clear()
                startActivity(v_LogIntent)
            }
            else
            {

            }
        }

    }



}