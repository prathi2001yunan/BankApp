package com.example.bank_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_app.databinding.RececivehistoryBinding
import com.example.bank_app.databinding.WithdrawsimpleBinding

class Recycle6(val list: List<Data4>): RecyclerView.Adapter<Recycle6.Mainholder>() {

    inner class Mainholder(val binding:RececivehistoryBinding): RecyclerView.ViewHolder(binding.root) {

        val acc = binding.text5
        val money = binding.text6

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        return Mainholder(RececivehistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        holder.acc.setText(list[position].nam)
        holder.money.setText(list[position].num)





    }

}
