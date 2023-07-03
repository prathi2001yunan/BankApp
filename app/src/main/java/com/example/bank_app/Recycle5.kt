package com.example.bank_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_app.databinding.BalancesimpleBinding
import com.example.bank_app.databinding.DepositsimpleBinding
import com.example.bank_app.databinding.TranssimpleBinding
import com.example.bank_app.databinding.WithdrawsimpleBinding


class Recycle5(val list: List<Data4>): RecyclerView.Adapter<Recycle5.Mainholder>() {

    inner class Mainholder(val binding: WithdrawsimpleBinding): RecyclerView.ViewHolder(binding.root) {

        val deposit = binding.textView18
        val balance = binding.textView4


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        return Mainholder(WithdrawsimpleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        holder.deposit.setText(list[position].nam)
        holder.balance.setText(list[position].num)





    }

}
