package com.example.educativecodeplayground.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educativecodeplayground.R
import com.example.educativecodeplayground.adapter.AssetsAdapter
import com.example.educativecodeplayground.databinding.FragmentAssetsBinding
import com.example.educativecodeplayground.viewModel.CoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetsFragment : Fragment(R.layout.fragment_assets) {

    private val viewModel: CoinViewModel by viewModels()

    private lateinit var assetsAdapter: AssetsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAssetsBinding.bind(view)

        assetsAdapter = AssetsAdapter(listener)

        fetchCoins()
        populateRecyclerview(binding)

    }

    private fun fetchCoins() {

        viewModel.assetsData.observe(viewLifecycleOwner) { assetsResponse ->
            assetsAdapter.differ.submitList(assetsResponse.data)
        }

    }

    private fun populateRecyclerview(binding: FragmentAssetsBinding) {
        binding.assetsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = assetsAdapter
        }

    }

    private val listener = AssetsAdapter.OnClickListener { name ->
        findNavController().navigate(
            AssetsFragmentDirections.actionAssetsFragment2ToCoinDetailsFragment(
                name
            )
        )
    }
}