package com.example.bank_app

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database4(context: Context): SQLiteOpenHelper(context,"USER2",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE USER2(NAM TEXT,NUM TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun settext4(nam: String,num:String): Boolean {
        var p0 = this.writableDatabase
        var c = ContentValues()
        c.put("NAM",nam)
        c.put("NUM",num)
        val result = p0.insert("USER2", null, c)
        if (result == -1.toLong()) {
            return false
        }

        return true


    }

    fun gettext4(): Cursor? {

        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM USER2", null)
        return cursor
    }
}