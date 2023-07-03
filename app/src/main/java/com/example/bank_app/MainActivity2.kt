package com.example.bank_app

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import com.example.bank_app.databinding.ActivityCheckBalanceBinding
import com.example.bank_app.databinding.ActivityMain2Binding
import com.example.bank_app.databinding.CustomupdateBinding
import com.example.bank_app.databinding.DepsoitmoneyBinding
import com.example.bank_app.databinding.WithdrawlBinding

class MainActivity2 : AppCompatActivity() {
    private var binding:ActivityMain2Binding?=null
    private var db2:Database2?=null
    private var listn:ArrayList<Data2>?=null
    private var listn1:ArrayList<Data2>?=null
    private var listrec:Recycle3?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        var button = findViewById<FrameLayout>(R.id.button2)
        button.setOnClickListener{
            startActivity(Intent(this,MainActivity3::class.java))
        }
        binding?.fram1?.setOnClickListener{
            startActivity(Intent(this,ReceiveHistory::class.java))
        }
        binding?.fram2?.setOnClickListener{

            startActivity(Intent(this,DepositMoney::class.java))

        }
        binding?.fram3?.setOnClickListener{
            startActivity(Intent(this,WithDraw::class.java))

        }
        binding?.fram4?.setOnClickListener{
            startActivity(Intent(this,Transaction::class.java))
        }

    }
}


