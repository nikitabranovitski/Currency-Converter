package com.branovitski.currencyconverter.network

import com.branovitski.currencyconverter.model.ExchangeRates
import retrofit2.Response

import retrofit2.http.GET


interface ApiService {

    @GET("rates?periodicity=0")
    suspend fun getList(): Response<ExchangeRates>

}