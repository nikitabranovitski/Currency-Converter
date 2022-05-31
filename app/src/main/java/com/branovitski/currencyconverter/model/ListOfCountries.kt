package com.branovitski.currencyconverter.model

object ListOfCountries {
    val listOfCountries = ArrayList<ExchangeRatesItem>()

    val map = mutableMapOf<String, Double>()

    val list1 = ArrayList<String>()
    val list2 = ArrayList<Double>()
    val list3 = ArrayList<Double>()
    var officialRate: Double = 0.0
    var abv: String = ""
}