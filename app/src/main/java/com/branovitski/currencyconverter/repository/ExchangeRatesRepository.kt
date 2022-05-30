package com.branovitski.currencyconverter.repository

import com.branovitski.currencyconverter.di.NetworkManager
import com.branovitski.currencyconverter.network.ApiService
import javax.inject.Inject

class ExchangeRatesRepository @Inject constructor(private val manager: NetworkManager) {

    suspend fun getList() = manager.provideUnauthorizedCachedRequestsApi().getList()
}