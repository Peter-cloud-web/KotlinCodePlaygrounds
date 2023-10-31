package com.example.educativecodeplayground.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.educativecodeplayground.databinding.ExchangesItemBinding
import com.example.educativecodeplayground.data.exchanges.Data

class ExchangesAdapter() : RecyclerView.Adapter<ExchangesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ExchangesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    val exchangesList = AsyncListDiffer(this, ExchangesComparator)

    companion object {
        private val ExchangesComparator =
            object : DiffUtil.ItemCallback<Data>() {
                override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                    return oldItem == newItem
                }


            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ExchangesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return exchangesList.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val exchangesData = exchangesList.currentList[position]
        with(holder){
            with(exchangesData){
                binding.apply {
                    exchangeName.text = name.toString()
                    exchangesVolume.text = volumeUsd.toString()
                }
            }
        }
    }
}