package com.example.educativecodeplayground.repository

import com.example.educativecodeplayground.api.ApiInterface
import com.example.educativecodeplayground.data.assets.AssetsResponse
import com.example.educativecodeplayground.data.coin_detail.CoinDetails
import com.example.educativecodeplayground.data.exchanges.ExchangesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CoinRepository {

    suspend fun getAssets(): Flow<Response<AssetsResponse>>

    suspend fun getExchanges():Flow<Response<ExchangesResponse>>

    suspend fun getCoinDetail(id:String):Flow<Response<CoinDetails>>
}