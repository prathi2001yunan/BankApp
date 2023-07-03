package com.example.bank_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bank_app.databinding.ActivityReceiveHistoryBinding
import com.example.bank_app.databinding.ActivityWithDrawBinding
import com.example.bank_app.databinding.RececivehistoryBinding

class ReceiveHistory : AppCompatActivity() {
    private var receive:ActivityReceiveHistoryBinding? = null

    private var newArray1: ArrayList<Data4>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receive=ActivityReceiveHistoryBinding.inflate(layoutInflater)
        setContentView(receive?.root)
        newArray1=ArrayList<Data4>()
        newArray1!!.add(Data4("Prathiyunan","2000"))
        newArray1!!.add(Data4("harish","2045"))

        newArray1!!.add(Data4("Punitha","1000"))

        newArray1!!.add(Data4("kishore","2400"))

        newArray1!!.add(Data4("Ram","2090"))

        newArray1!!.add(Data4("Raj","2900"))

        newArray1!!.add(Data4("vinoth","900"))
        val list6 = Recycle6(newArray1!!)
        receive?.recyclerView?.adapter=list6




    }
}