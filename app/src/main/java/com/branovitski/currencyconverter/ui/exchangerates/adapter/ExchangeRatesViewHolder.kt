package com.branovitski.currencyconverter.ui.exchangerates.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.branovitski.currencyconverter.databinding.ListItemBinding
import com.branovitski.currencyconverter.model.ExchangeRatesItem
import com.bumptech.glide.Glide

class ExchangeRatesViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ExchangeRatesItem) {
        binding.titleTextView.text = item.Cur_Name
        binding.bunTextView.text = "1 BUN = "
        binding.ratesTextView.text = item.Cur_OfficialRate.toString() + " " + item.Cur_Abbreviation
    }
}