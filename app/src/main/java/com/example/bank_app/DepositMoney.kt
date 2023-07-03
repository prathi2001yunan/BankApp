package com.example.bank_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.bank_app.databinding.ActivityDepositMoneyBinding
import com.example.bank_app.databinding.ActivityTransactionBinding

class DepositMoney : AppCompatActivity() {
    private var deposit: ActivityDepositMoneyBinding? = null
    private var list1: ArrayList<Data1>? = null
    private var newArray1: ArrayList<Data1>? = null
    private var rec: Recycle4? = null
    private var db2: Database4? = null
    private var db1: Database2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deposit = ActivityDepositMoneyBinding.inflate(layoutInflater)
        setContentView(deposit?.root)
        getRecycle()
        db2 = Database4(this)

        deposit?.button4?.setOnClickListener {





            var value1 = deposit?.editTextTextPersonName?.text.toString().toInt()
            if (TextUtils.isEmpty(value1.toString())) {
                Toast.makeText(this, "CHECK DATA", Toast.LENGTH_LONG)
                    .show()
            }
            setRecycle(value1)
            getRecycle()



        }
    }
    private fun getRecycle() {
        list1 = ArrayList<Data1>()
        db2 = Database4(this)

        val newcursor = db2!!.gettext4()

        newArray1 = ArrayList<Data1>()

        while (newcursor!!.moveToNext()) {
            val nam = newcursor.getString(0)


            val num = newcursor.getString(1)
            newArray1!!.add(Data1(nam,num))

        }
        list1!!.addAll(newArray1!!)
        rec = Recycle4(list1!!)
        deposit?.rec?.adapter=rec

    }
    private fun setRecycle(value1:Int){
        db1 = Database2(this)
        var cursor = db1!!.gettext1()
        var pass: String? = null
        if (cursor!!.moveToFirst()) {
            val pass1 = cursor.getString(0).toInt()

            pass = (pass1 + value1).toString()
        }

        if (pass!!.isNotEmpty()) {
            deposit?.button4?.visibility = View.GONE
            deposit?.button45?.visibility = View.VISIBLE

            deposit?.button45?.setOnClickListener {
                deposit?.textView15?.text = pass
                deposit?.textView14?.visibility = View.VISIBLE
                val n1 = deposit?.editTextTextPersonName?.text.toString()
                val n2 = pass
                val set = db2!!.settext4(n1,n2)
                if(set==true){
                    Toast.makeText(this, " DATA ADDED", Toast.LENGTH_LONG).show()


                }
                else {
                    Toast.makeText(this, "CHECK DATA", Toast.LENGTH_LONG).show()

                }
            }

        }
    }
}

