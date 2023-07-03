package com.example.bank_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_app.databinding.SimpleBinding
import com.example.bank_app.databinding.TranssimpleBinding


class Recycle2(val list: List<Data1>): RecyclerView.Adapter<Recycle2.Mainholder>() {

    inner class Mainholder(val binding: TranssimpleBinding): RecyclerView.ViewHolder(binding.root) {

        val name = binding.textView11
        val num = binding.textView12

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        return Mainholder(TranssimpleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        holder.name.text = list[position].nam
        holder.num.text = list[position].num




    }

}
