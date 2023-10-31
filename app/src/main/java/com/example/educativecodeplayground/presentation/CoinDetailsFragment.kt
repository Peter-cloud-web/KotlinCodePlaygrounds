package com.example.educativecodeplayground.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.educativecodeplayground.R
import com.example.educativecodeplayground.databinding.FragmentCoinDetailsBinding
import com.example.educativecodeplayground.util.CryptoIconUrl
import com.example.educativecodeplayground.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailsFragment : Fragment(R.layout.fragment_coin_details) {
    private var fragmentCoinDetailsBinding:FragmentCoinDetailsBinding? = null
     val viewModel:CoinViewModel by viewModels()

    val args:CoinDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCoinDetailsBinding.bind(view)
        fragmentCoinDetailsBinding = binding

        viewModel.getCoinDetail(args.name)
        Log.d("COINDETAIL : ","ID = ${args.name}")
        viewModel.coinDetail?.observe(viewLifecycleOwner){ coinDetails ->
            binding.apply {
                coinDetails?.data?.apply {
                    Glide.with(coinIconImage)
                        .load(CryptoIconUrl + symbol.toString().toLowerCase())
                        .into(coinIconImage)
                    symbolText.text = symbol.toString()
                    cryptoNameText.text = name.toString()
                    supplyText.text = supply.toString()
                    priceUSDText.text = priceUsd.toString()
                    maxSupplyText.text = maxSupply.toString()
                }
            }

        }
    }








}