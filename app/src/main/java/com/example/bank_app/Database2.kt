package com.example.bank_app


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database2(context: Context):SQLiteOpenHelper(context,"AMOUNT",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE AMOUNT(NAME TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun settext1(amount:String):Boolean{
        var p0 = this.writableDatabase
        var c = ContentValues()
        c.put("NAME",amount)


        val result = p0.insert("AMOUNT",null,c)
        if(result==-1.toLong()) {
            return false
        }

        return true


    }

    fun update2(nam:String):Boolean {
        val db = this.writableDatabase
        val c = ContentValues()
        c.put("NAME", nam)
        val count: Cursor = db.rawQuery("SELECT * FROM AMOUNT WHERE NAME=?", arrayOf(nam))
        if (count.count >0) {
            val result = db.update("AMOUNT", c, "NAME=?", arrayOf(nam))
            return true
        } else {
            return false
        }
    }
    fun gettext1(): Cursor? {

        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM AMOUNT", null)
        return cursor
    }
}