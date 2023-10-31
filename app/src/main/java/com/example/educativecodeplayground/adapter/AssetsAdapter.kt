package com.example.educativecodeplayground.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.educativecodeplayground.data.assets.Data
import com.example.educativecodeplayground.databinding.AssetsItemBinding
import com.example.educativecodeplayground.util.CryptoIconUrl

class AssetsAdapter(private val onClickListener:OnClickListener) : RecyclerView.Adapter<AssetsAdapter.AssetsViewHolder>() {

    inner class AssetsViewHolder(val binding: AssetsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    val differ = AsyncListDiffer(this, AssetsComparator)



    companion object {
        private val AssetsComparator =
            object : DiffUtil.ItemCallback<Data>() {
                override fun areItemsTheSame(
                    oldItem: Data,
                    newItem: Data
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Data,
                    newItem: Data
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsViewHolder {
        val binding = AssetsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetsViewHolder, position: Int) {
        val assetsData = differ.currentList[position]
        with(holder) {
            with(assetsData) {
                binding.apply {
                    Glide.with(itemView)
                        .load(CryptoIconUrl + assetsData.symbol.toString().toLowerCase())
                        .into(coinIcon)
                    symbol.text = assetsData.symbol.toString()
                    cryptoName.text = name.toString()

                    holder.itemView.setOnClickListener {
                        onClickListener.onClick(id)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class OnClickListener(val clickListener: (id:String) -> Unit){
        fun onClick(id: String) = clickListener(id)
    }
}