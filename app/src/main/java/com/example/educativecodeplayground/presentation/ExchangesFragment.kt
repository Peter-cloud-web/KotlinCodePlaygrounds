package com.example.educativecodeplayground.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educativecodeplayground.R
import com.example.educativecodeplayground.adapter.ExchangesAdapter
import com.example.educativecodeplayground.databinding.FragmentExchangesBinding
import com.example.educativecodeplayground.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangesFragment : Fragment() {

    private val viewModel: CoinViewModel by viewModels()

    private lateinit var exchangesAdapter: ExchangesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exchanges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentExchangesBinding.bind(view)

        exchangesAdapter = ExchangesAdapter()

        fetchExchanges()
        populateRecyclerView(binding)
    }

    fun fetchExchanges() {
        viewModel.exchangeData.observe(viewLifecycleOwner) { exchangeResponse ->
            exchangesAdapter.exchangesList.submitList(exchangeResponse.data)
        }
    }

    fun populateRecyclerView(binding:FragmentExchangesBinding){
        binding.exchangesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = exchangesAdapter
        }

    }
}