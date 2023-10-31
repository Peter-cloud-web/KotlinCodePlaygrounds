package com.example.educativecodeplayground.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.educativecodeplayground.data.assets.AssetsResponse
import com.example.educativecodeplayground.data.coin_detail.CoinDetails
import com.example.educativecodeplayground.data.exchanges.ExchangesResponse
import com.example.educativecodeplayground.repository.CoinRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val repository: CoinRepositoryImpl) : ViewModel() {

    private val _exchngesData = MutableLiveData<ExchangesResponse>()
    val exchangeData: LiveData<ExchangesResponse> = _exchngesData

    private val _assetsData = MutableLiveData<AssetsResponse>()
    val assetsData: LiveData<AssetsResponse> = _assetsData

    private val _coinDetail = MutableLiveData<CoinDetails>()
    val coinDetail: LiveData<CoinDetails> = _coinDetail

    init {
        getAssets()
        getExchanges()
    }

    fun getExchanges() {
        viewModelScope.launch {
            repository.getExchanges().collect {
                _exchngesData.postValue(it.body())
            }
        }
    }

    fun getAssets() {
        viewModelScope.launch {
            repository.getAssets().collect {
                _assetsData.postValue(it.body())
            }
        }
    }

    fun getCoinDetail(id:String){
        viewModelScope.launch {
            repository.getCoinDetail(id).collect{
                _coinDetail.postValue(it.body())
            }
        }
    }
}