package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class DiceGame : AppCompatActivity() {
    var v_ImageView:ImageView?=null
    var v_Button:Button?=null
    var v_Player1:TextView?=null
    var v_Player2:TextView?=null
    var Result:TextView?=null
    var num=1
    var imageName=""
    var player1_Val=0
    var player2_Val=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_game)

        v_ImageView=findViewById<ImageView>(R.id.imageView)
        v_Button=findViewById<Button>(R.id.button_Play)
        v_Player1=findViewById<TextView>(R.id.textView_player1)
        v_Player2=findViewById<TextView>(R.id.textView_player2)
        Result=findViewById<TextView>(R.id.textview_Result)

        v_Button!!.setOnClickListener {
            if(player1_Val!=0 && player2_Val!=0)
            {
                super.onStop()
                super.onRestart()
            }

            num= Random.nextInt(1,6)
            if(num==1)
            {
                imageName="@drawable/dice1"
            }
            else if(num==2)
            {
                imageName="@drawable/dice2"
            }
            else if(num==3)
            {
                imageName="@drawable/dice3"
            }
            else if(num==4)
            {
                imageName="@drawable/dice4"
            }
            else if(num==5)
            {
                imageName="@drawable/dice5"
            }
            else if(num==6)
            {
                imageName="@drawable/dice6"
            }
            v_ImageView!!.setImageResource(getResources().getIdentifier(imageName,null,this.packageName))

            if(player1_Val>0)
            {
                player2_Val=num
                v_Player2!!.setText(player2_Val.toString())
            }
            else
            {
                player1_Val=num
                v_Player1!!.setText(player1_Val.toString())
            }

            if (player1_Val>player2_Val)
            {
                Result!!.setText("player 1 won")
            }else if(player1_Val==player2_Val)
            {
                Result!!.setText("Match draw")
            }
            else
            {
                Result!!.setText("player 2 won")
            }


        }

    }
}