package com.example.bank_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.bank_app.databinding.ActivityTransactionBinding

class Transaction : AppCompatActivity() {
    private var binding: ActivityTransactionBinding? = null

    private var list1: ArrayList<Data1>? = null
    private var newArray1: ArrayList<Data1>? = null
    private var rec: Recycle2? = null
    private var db2: Database3? = null
    private var db1: Database2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getRecycle()
        db2 = Database3(this)


        binding?.button4?.setOnClickListener {

            val nam = binding?.editTextTextPersonName1?.text.toString()
            val num = binding?.editTextTextPersonName?.text.toString()
            val result = db2?.settext3(nam, num)
            if (result == true) {
                Toast.makeText(this, " DATA ADDED success", Toast.LENGTH_LONG).show()
                db1 = Database2(this)
                var cursor = db1!!.gettext1()
                var pass: String? = null
                var value1=0
                if (cursor!!.moveToFirst()) {
                    val pass1 = cursor.getString(0).toInt()

                   value1= binding?.editTextTextPersonName?.text.toString().toInt()
                    pass = (pass1 - value1).toString()
                }

                if (pass!!.isNotEmpty()) {
                    binding?.textView20?.visibility=View.VISIBLE
                    binding?.textView21?.visibility=View.VISIBLE

                   binding?.textView21?.setText(pass)



                }
            }

        }
    }
        private fun getRecycle() {
            list1 = ArrayList<Data1>()
            db2 = Database3(this)
            val newcursor = db2!!.gettext3()

            newArray1 = ArrayList<Data1>()

            while (newcursor!!.moveToNext()) {
                val nam = newcursor.getString(0)


                val num = newcursor.getString(1)
                newArray1!!.add(Data1(nam, num))

            }
            list1!!.addAll(newArray1!!)
            rec = Recycle2(list1!!)
            binding?.rec?.adapter = rec
        }
    }




