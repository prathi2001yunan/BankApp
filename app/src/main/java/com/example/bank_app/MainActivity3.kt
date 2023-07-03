package com.example.bank_app

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.example.bank_app.databinding.ActivityMain3Binding
import com.example.bank_app.databinding.CustomupdateBinding

import kotlin.collections.ArrayList

class MainActivity3 : AppCompatActivity() {
    private var binding:ActivityMain3Binding?=null
    private var newArray: ArrayList<Data>? = null
    private var newArray1: ArrayList<Data>? = null
    private var listrec: Recycle? = null

    private var db1: DatabaseHelper? = null
    private var text1:TextView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        db1 = DatabaseHelper(this)
        text1=findViewById(R.id.textView4)
        getRecycle()
        binding?.button3?.setOnClickListener{
           val custom = Dialog(this)
            var custom2 :CustomupdateBinding?= null
            custom2 = CustomupdateBinding.inflate(layoutInflater)
            custom.setContentView(custom2.root)
            custom.setCanceledOnTouchOutside(false)


            custom2.editTextTextPersonName.setText( newArray1?.get(0)?.nam)
            custom2.editDob.setText( newArray1?.get(0)?.dob)
            custom2.editaddress.setText( newArray1?.get(0)?.add)
            custom2.editPhone.setText( newArray1?.get(0)?.phno)
            custom2.editGender.setText( newArray1?.get(0)?.gen)
            custom2.editadh.setText( newArray1?.get(0)?.addh)
            custom2.editpan.setText( newArray1?.get(0)?.pan)
            custom2.editEmail.setText( newArray1?.get(0)?.email)
            val nam =   custom2.editTextTextPersonName.text.toString()
            val dob =   custom2.editDob.text.toString()
            val email =   custom2.editEmail.text.toString()
            val phno =   custom2.editPhone.text.toString()
            val gen =   custom2.editGender.text.toString()
            val add =   custom2.editaddress.text.toString()
            val adh =   custom2.editadh.text.toString()
            val pan =   custom2.editpan.text.toString()
            custom2.button.setOnClickListener{
                val nam =   custom2.editTextTextPersonName.text.toString()
                val dob =   custom2.editDob.text.toString()
                val email =   custom2.editEmail.text.toString()
                val phno =   custom2.editPhone.text.toString()
                val gen =   custom2.editGender.text.toString()
                val add =   custom2.editaddress.text.toString()
                val adh =   custom2.editadh.text.toString()
                val pan =   custom2.editpan.text.toString()
                val update = db1!!.updateText(nam,dob,email,phno,gen,add,adh,pan)
                if (update == true) {
                    Toast.makeText(this@MainActivity3, "UPDATED DATA", Toast.LENGTH_LONG).show()
                    this@MainActivity3.finish()

                } else {
                    Toast.makeText(this@MainActivity3, "DATA NOT UPDATED", Toast.LENGTH_LONG).show()

                }
            }
            custom.show()

        }
    }

    private fun getRecycle() {
        val newcursor = db1!!.gettext()
        newArray=ArrayList<Data>()
        newArray1=ArrayList<Data>()

        while (newcursor!!.moveToNext()) {
            val name = newcursor.getString(0)



            val dob = newcursor.getString(1)

            val email = newcursor.getString(2)
            val phno = newcursor.getString(3)


            val  gen = newcursor.getString(4)

            val add = newcursor.getString(5)

            val addh = newcursor.getString(6)

            val pan = newcursor.getString(7)

            newArray?.add(Data(name,dob, email, phno, gen, add, addh, pan))


        }
        newArray1?.addAll(newArray!!)
        listrec= Recycle(newArray1!!)
        binding?.rec?.adapter=listrec

    }
    }
