package com.example.educativecodeplayground.repository

import com.example.educativecodeplayground.api.ApiInterface
import com.example.educativecodeplayground.data.assets.AssetsResponse
import com.example.educativecodeplayground.data.coin_detail.CoinDetails
import com.example.educativecodeplayground.data.exchanges.ExchangesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface) :
    CoinRepository {

    override suspend fun getAssets(): Flow<Response<AssetsResponse>> = flow {
        val response = apiInterface.getAssets()
        emit(response)
    }

    override suspend fun getExchanges(): Flow<Response<ExchangesResponse>> = flow {
        val response = apiInterface.getExchanges()
        emit(response)
    }

    override suspend fun getCoinDetail(id:String): Flow<Response<CoinDetails>> = flow {
        val response = apiInterface.getCoinDetail(id)
        emit(response)
    }

}