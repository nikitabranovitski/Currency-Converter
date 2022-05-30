package com.branovitski.currencyconverter.ui.exchangerates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.branovitski.currencyconverter.model.ExchangeRatesItem
import com.branovitski.currencyconverter.model.ListOfCountries
import com.branovitski.currencyconverter.repository.ExchangeRatesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeRatesViewModel @Inject constructor(private val repository: ExchangeRatesRepository) :
    ViewModel() {

    val list = MutableLiveData<ArrayList<ExchangeRatesItem>>()

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getList()
            if (response.isSuccessful) {
                list.postValue(response.body())
            }
        }
    }
}