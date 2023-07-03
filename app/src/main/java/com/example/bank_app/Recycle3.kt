package com.example.bank_app


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_app.databinding.BalancesimpleBinding
import com.example.bank_app.databinding.SimpleBinding
import com.example.bank_app.databinding.TranssimpleBinding


class Recycle3(val list: List<Data2>): RecyclerView.Adapter<Recycle3.Mainholder>() {

    inner class Mainholder(val binding: BalancesimpleBinding): RecyclerView.ViewHolder(binding.root) {

        val name = binding.textView16


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        return Mainholder(BalancesimpleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        holder.name.text = list[position].nam





    }

}
