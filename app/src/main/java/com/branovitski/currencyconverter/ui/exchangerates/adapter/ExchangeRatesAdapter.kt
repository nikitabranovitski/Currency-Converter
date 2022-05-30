package com.branovitski.currencyconverter.ui.exchangerates.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.branovitski.currencyconverter.databinding.ListItemBinding
import com.branovitski.currencyconverter.model.ExchangeRatesItem

class ExchangeRatesAdapter(private val context: Context) :
    RecyclerView.Adapter<ExchangeRatesViewHolder>() {

    private var list: ArrayList<ExchangeRatesItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRatesViewHolder {
        return ExchangeRatesViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExchangeRatesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(listData: ArrayList<ExchangeRatesItem>) {
        list = listData
        notifyDataSetChanged()
    }
}