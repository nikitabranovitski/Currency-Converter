package com.branovitski.currencyconverter.model

data class ExchangeRatesItem(
    val Cur_Abbreviation: String,
    val Cur_ID: Int,
    val Cur_Name: String,
    val Cur_OfficialRate: Double,
    val Cur_Scale: Int,
    val Date: String
)