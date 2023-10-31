package com.example.educativecodeplayground.api

import com.example.educativecodeplayground.data.assets.AssetsResponse
import com.example.educativecodeplayground.data.coin_detail.CoinDetails
import com.example.educativecodeplayground.data.exchanges.ExchangesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/v2/exchanges")
    suspend fun getExchanges(): Response<ExchangesResponse>

    @GET("/v2/assets")
    suspend fun getAssets():Response<AssetsResponse>

    @GET("/v2/assets/{id}")
    suspend fun getCoinDetail(@Path("id") id: String): Response<CoinDetails>
}