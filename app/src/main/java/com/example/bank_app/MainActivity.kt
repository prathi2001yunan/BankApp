package com.example.bank_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.bank_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var bind: ActivityMainBinding?=null
    private var db: DatabaseHelper?=null
    private var db1: Database2?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind?.root)
        db = DatabaseHelper(this)
        db1 = Database2(this)
        val cr = db!!.gettext()

        if (cr!!.moveToFirst()) {
            if (cr.getString(0).isNotEmpty()) {

                this@MainActivity.finish()
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            }
        }
        else {

            bind?.button?.setOnClickListener {
                var nam = bind?.editTextTextPersonName?.text.toString()
                var dob = bind?.editDob?.text.toString()
                var email = bind?.editEmail?.text.toString()
                var phno = bind?.editPhone?.text.toString()
                var gen = bind?.editGender?.text.toString()
                var add = bind?.editaddress?.text.toString()
                var addh = bind?.editadh?.text.toString()
                var pan = bind?.editpan?.text.toString()
                var amount = bind?.editmoney?.text.toString()
                var savedata = db?.settext(nam, dob, email, phno, gen, add, addh, pan)
                var savedata1 = db1?.settext1(amount)
                if (TextUtils.isEmpty(nam) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                        phno
                    ) || TextUtils.isEmpty(gen) || TextUtils.isEmpty(add) || TextUtils.isEmpty(addh) || TextUtils.isEmpty(
                        pan
                    ) || TextUtils.isEmpty(amount)
                ) {
                    Toast.makeText(this, "Enter the details   ", Toast.LENGTH_LONG).show()
                } else {
                    if (savedata == true && savedata1==true) {
                        Toast.makeText(
                            this,
                            "data entered successfully",
                            Toast.LENGTH_LONG
                        )
                            .show()
                        startActivity(Intent(this, MainActivity2::class.java))
                    } else {
                        Toast.makeText(this, "exist contact", Toast.LENGTH_LONG)
                            .show()
                    }

                }

            }
        }
    }
}