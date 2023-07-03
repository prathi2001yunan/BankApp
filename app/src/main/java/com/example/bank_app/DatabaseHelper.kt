package com.example.bank_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,"UserDb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE USERDB(NAME TEXT,DOB TEXT,EMAIL TEXT,PHNO TEXT,GENDER TEXT,ADDRESS TEXT,ADHAR TEXT,PAN TEXT)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun settext(name:String ,dob:String,email:String,phno:String,gender:String,address:String,adhar:String,pan:String):Boolean{
        var p0 = this.writableDatabase
        var c = ContentValues()
        c.put("NAME",name)
        c.put("DOB",dob)
        c.put("EMAIL",email)
        c.put("PHNO",phno)
        c.put("GENDER",gender)
        c.put("ADDRESS",address)
        c.put("ADHAR",adhar)
        c.put("PAN",pan)

        val result = p0.insert("USERDB",null,c)
        if(result==-1.toLong()) {
            return false
        }

        return true


    }

    fun updateText(name:String ,dob:String,email:String,phno:String,gender:String,address:String,adhar:String,pan:String):Boolean {
        val db = this.writableDatabase
        val c = ContentValues()
        c.put("NAME",name)
        c.put("DOB",dob)
        c.put("EMAIL",email)
        c.put("PHNO",phno)
        c.put("GENDER",gender)
        c.put("ADDRESS",address)
        c.put("ADHAR",adhar)
        c.put("PAN",pan)


        val count:Cursor= db.rawQuery("SELECT * FROM USERDB WHERE NAME=?", arrayOf(name))
        if(count.count>0){
            val result = db.update("USERDB",c,"NAME=?", arrayOf(name))
            return true
        }
        else{
            return false
        }
    }



    fun gettext(): Cursor? {

        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM USERDB", null)
        return cursor
    }
}


