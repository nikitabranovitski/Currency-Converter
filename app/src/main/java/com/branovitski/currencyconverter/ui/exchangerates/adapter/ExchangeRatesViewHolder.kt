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
        binding.bunTextView.text = item.Cur_Scale.toString() + " " + item.Cur_Abbreviation + " = "
        binding.ratesTextView.text = item.Cur_OfficialRate.toString() + " BUN"
    }
}