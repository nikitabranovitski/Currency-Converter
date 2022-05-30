package com.branovitski.currencyconverter.ui.calculator

import androidx.lifecycle.ViewModel
import com.branovitski.currencyconverter.model.ListOfCountries
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {

    fun getLists() {
        ListOfCountries.listOfCountries.forEach {
            ListOfCountries.map[it.Cur_Abbreviation] = it.Cur_OfficialRate
            ListOfCountries.list1.add(it.Cur_Abbreviation)
            ListOfCountries.list2.add(it.Cur_OfficialRate)
        }
    }

    fun calculate(num1: Double, num2: Double) = num2 / num1
}