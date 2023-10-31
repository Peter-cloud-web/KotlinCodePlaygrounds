package com.example.educativecodeplayground.data.assets

import java.io.Serializable

data class Data(
    val changePercent24Hr: String,
    val id: String,
    val marketCapUsd: String,
    val maxSupply: String,
    val name: String,
    val priceUsd: String,
    val rank: String,
    val supply: String,
    val symbol: String,
    val volumeUsd24Hr: String,
    val vwap24Hr: String
):Serializable