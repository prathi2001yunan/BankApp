package com.example.bank_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bank_app.databinding.SimpleBinding

class Recycle(val list: List<Data>):RecyclerView.Adapter<Recycle.Mainholder>() {

    inner class Mainholder(val binding:SimpleBinding): RecyclerView.ViewHolder(binding.root) {

        val name = binding.textView4
       val dob = binding.textView7
       val email = binding.textView71
        val phno = binding.textView712
        val gender = binding.textView714
       val add = binding.textView7134
       val adhr =  binding.textView713
        val pan = binding.textView713456

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mainholder {
        return Mainholder(SimpleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Mainholder, position: Int) {
        holder.name.text = list[position].nam
        holder.dob.text = list[position].dob
        holder.email.text = list[position].email
        holder.phno.text = list[position].phno
        holder.gender.text = list[position].gen
        holder.add.text = list[position].add
        holder.adhr.text = list[position].addh
        holder.pan.text = list[position].pan




    }

}
