package com.example.loginapp



import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Calculator : AppCompatActivity() {
    val myList=ArrayList<Any>()
    val myList_input=ArrayList<Any>()
    var v_textView: TextView?=null
    var v_outPutTextView: TextView?=null
    var v_Btn_1:Button?=null
    var v_Btn_2:Button?=null
    var v_Btn_3:Button?=null
    var v_Btn_4:Button?=null
    var v_Btn_5:Button?=null
    var v_Btn_6:Button?=null
    var v_Btn_7:Button?=null
    var v_Btn_8:Button?=null
    var v_Btn_9:Button?=null
    var v_Addition:Button?=null
    var v_Substraction:Button?=null
    var v_Clear:Button?=null
    var v_numberOfvalues=0
    var v_numberOfvalues_input=0
    var v_String:String?=""
    var v_outPut=0.0
    var v_MathSign=""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        v_textView=findViewById<TextView>(R.id.inputTextView)
        v_outPutTextView=findViewById<TextView>(R.id.outputTextView)
        v_Btn_1=findViewById<Button>(R.id.button_num1)
        v_Btn_2=findViewById<Button>(R.id.button_num2)
        v_Btn_3=findViewById<Button>(R.id.button_num3)
        v_Btn_4=findViewById<Button>(R.id.button_num4)
        v_Btn_5=findViewById<Button>(R.id.button_num5)
        v_Btn_6=findViewById<Button>(R.id.button_num6)
        v_Btn_7=findViewById<Button>(R.id.button_num7)
        v_Btn_8=findViewById<Button>(R.id.button_num8)
        v_Btn_9=findViewById<Button>(R.id.button_num9)
        v_Addition=findViewById<Button>(R.id.button_Addition)
        v_Substraction=findViewById<Button>(R.id.button_Substraction)
        v_Clear=findViewById<Button>(R.id.button_Clear)

        fun logic()
        {
            if(v_MathSign.equals("+")||v_MathSign.equals("-"))
            {
                if(myList_input.isNotEmpty() and v_String.isNullOrEmpty()!=true)
                {
                    v_numberOfvalues_input+=1
                    if(myList_input.lastIndex==1)
                    {
                        myList_input.set(v_numberOfvalues_input, v_String.toString().toDouble())
                    }
                    else
                    {
                        myList_input.add(v_numberOfvalues_input, v_String.toString().toDouble())
                    }

                    v_String=""
                }
                if(v_MathSign.equals("+"))
                {
                    v_outPut=Calculations(myList_input).Add_Function()
                }
                else{
                    v_outPut=Calculations(myList_input).Sub_Function()
                }


                v_numberOfvalues_input=0
                v_outPutTextView!!.setText(v_outPut.toString())
            }
        }
        fun clear(){
            myList.clear()
            myList_input.clear()
            v_outPut=0.0
            v_numberOfvalues=0
            v_numberOfvalues_input=0
            v_String=""
            v_MathSign=""
            v_textView!!.setText("")
            v_outPutTextView!!.setText("")
        }

        v_Btn_1!!.setOnClickListener {
            myList.add(v_numberOfvalues,1)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"1")
            logic()

        }
        v_Btn_2!!.setOnClickListener {
            myList.add(v_numberOfvalues,2)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"2")
            logic()

        }
        v_Btn_3!!.setOnClickListener {
            myList.add(v_numberOfvalues,3)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"3")
            logic()

        }
        v_Btn_4!!.setOnClickListener {
            myList.add(v_numberOfvalues,4)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"4")
            logic()

        }
        v_Btn_5!!.setOnClickListener {
            myList.add(v_numberOfvalues,5)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"5")
            logic()

        }
        v_Btn_6!!.setOnClickListener {
            myList.add(v_numberOfvalues,6)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"6")
            logic()

        }
        v_Btn_7!!.setOnClickListener {
            myList.add(v_numberOfvalues,7)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"7")
            logic()

        }
        v_Btn_8!!.setOnClickListener {
            myList.add(v_numberOfvalues,8)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"8")
            logic()

        }
        v_Btn_9!!.setOnClickListener {
            myList.add(v_numberOfvalues,9)
            v_numberOfvalues=v_numberOfvalues+1

            for (i in myList) {
                v_String = v_String + i.toString()
            }
            v_textView!!.setText(v_textView!!.text.toString()+"9")
            logic()

        }

        //Addition calling
        v_Addition!!.setOnClickListener {

            v_textView!!.setText(v_textView!!.text.toString()+"+")
            v_numberOfvalues=0
            if(v_MathSign.isNullOrEmpty()!=true)
            {
                myList_input.set(v_numberOfvalues_input, v_outPut)
            }
            else{
                myList_input.add(v_numberOfvalues_input, v_String.toString().toDouble())
            }

            myList.clear()
            v_String=""
            v_MathSign="+"
        }

        //Substraction
        v_Substraction!!.setOnClickListener {
            v_textView!!.setText(v_textView!!.text.toString()+"-")
            v_numberOfvalues=0
            if(v_MathSign.isNullOrEmpty()!=true)
            {
                myList_input.set(v_numberOfvalues_input, v_outPut)
            }
            else{
                myList_input.add(v_numberOfvalues_input, v_String.toString().toDouble())
            }

            myList.clear()
            v_String=""
            v_MathSign="-"
        }
        //clear
        v_Clear!!.setOnClickListener {
            clear()
        }


    }
}