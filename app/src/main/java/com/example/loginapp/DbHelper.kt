package com.example.loginapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbHelper (context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){
    companion object{
        var DATABASE_NAME="Users.db"
        var DATABASE_VERSION=1
        val tblName="tblusers"
        val userId="userId"
        val userFullName="userFullName"
        val userPssword="userPassword"
        val usertype="userType"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query="Create table "+ tblName+"("+ userId+" Integer Primary Key Autoincrement, "+ userFullName+" Text,"+ userPssword+" Text,"+ usertype+" Text)"
        if (db!=null){
            db.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val query="DROP TABLE IF EXISTS "+tblName
        if(db!=null){
            db.execSQL(query)
            onCreate(db)
        }
    }

    fun addUser(name:String,password:String,type:String){
        val db=this.writableDatabase
        val values= ContentValues()
        values.put(userFullName,name)
        values.put(userPssword,password)
        values.put(usertype,type)
        db.insert(tblName,null,values)
    }

    fun readAll(): MutableList<UsersList> {
        val db=this.readableDatabase
        var cursor: Cursor?=null
        val query="Select * from "+ tblName
        val userdata= mutableListOf<UsersList>()

        cursor=db.rawQuery(query,null)

        while(cursor.moveToNext()){
            var userId=cursor.getInt(cursor.getColumnIndexOrThrow(userId))
            var strUsername=cursor.getString(cursor.getColumnIndexOrThrow(userFullName))
            var password=cursor.getString(cursor.getColumnIndexOrThrow(userPssword))
            var UserType=cursor.getString(cursor.getColumnIndexOrThrow(usertype))
            val user=UsersList(userId,strUsername,password,UserType)
            userdata.add(user)
        }
        return userdata

    }

    fun readPassword(name:String,password:String):Boolean{
        val db=this.readableDatabase
        var cursor: Cursor?=null
        val query="SELECT EXISTS (SELECT * FROM " +tblName+" WHERE "+ userFullName +"='"+ name +"' AND "+ userPssword +" = '"+password +"')"

        cursor=db.rawQuery(query,null)

        var exists = false
        if (cursor.moveToFirst()) {
            exists = cursor.getInt(0) == 1
        }
        cursor.close()
        return exists
    }

    fun getUserType(customer:String):String{
        val db=this.readableDatabase
        var cursor: Cursor?=null
        val qry="select $usertype from $tblName where $userFullName='$customer'"

         var v_usertype:String?=null
        try {
            cursor=db.rawQuery(qry,null)
            if (cursor.moveToFirst()) {
                v_usertype = cursor.getString(0)
            }
            cursor.close()

        }catch (e:Exception)
        {
            Log.e(ContentValues.TAG,"Error getting user type")
        }
        return v_usertype.toString()
    }

    fun deleteCustomer(customerID:Int):Boolean{
        val qry="Delete from $tblName where $userId=$customerID"
        val db=this.writableDatabase
        var result =false
        try {
            val cursor=db.execSQL(qry)
            result=true
        }catch (e:Exception)
        {
            Log.e(ContentValues.TAG,"Error Deleting")
        }
        db.close()
        return result
    }
}