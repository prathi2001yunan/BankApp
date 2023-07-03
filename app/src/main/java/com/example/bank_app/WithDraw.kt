package com.example.bank_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.bank_app.databinding.ActivityDepositMoneyBinding
import com.example.bank_app.databinding.ActivityWithDrawBinding

class WithDraw : AppCompatActivity() {
    private var with: ActivityWithDrawBinding? = null
    private var list1: ArrayList<Data4>? = null
    private var newArray1: ArrayList<Data4>? = null
    private var rec: Recycle5? = null
    private var db2: Database5? = null
    private var db1: Database2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with = ActivityWithDrawBinding.inflate(layoutInflater)
        setContentView(with?.root)


        db2 = Database5(this)
        getRecycle()
        with?.button4?.setOnClickListener {




            var value1 = with?.editTextTextPersonName?.text.toString().toInt()
            if (TextUtils.isEmpty(value1.toString())) {
                Toast.makeText(this, "CHECK DATA", Toast.LENGTH_LONG)
                    .show()
            }
            setRecycle(value1)
           with?.rec?.adapter?.notifyDataSetChanged()



        }
    }
    private fun getRecycle() {
        list1 = ArrayList<Data4>()
        db2 = Database5(this)

        val newcursor = db2!!.gettext5()

        newArray1 = ArrayList<Data4>()

        while (newcursor!!.moveToNext()) {
            val nam = newcursor.getString(0)


            val num = newcursor.getString(1)
            newArray1!!.add(Data4(nam,num))

        }
        list1!!.addAll(newArray1!!)
        rec = Recycle5(list1!!)
       with?.rec?.adapter=rec

    }
    private fun setRecycle(value1:Int){
        db1 = Database2(this)
        var cursor = db1!!.gettext1()
        var pass: String? = null
        if (cursor!!.moveToFirst()) {
            val pass1 = cursor.getString(0).toInt()

            pass = (pass1 - value1).toString()
        }

        if (pass!!.isNotEmpty()) {
            with?.button4?.visibility = View.GONE
            with?.button45?.visibility = View.VISIBLE

            with?.button45?.setOnClickListener {
                with?.textView15?.text = pass
                with?.textView14?.visibility = View.VISIBLE
                val n1 =with?.editTextTextPersonName?.text.toString()
                val n2 = pass
                val set = db2!!.settext5(n1,n2)

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




