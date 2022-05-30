package com.branovitski.currencyconverter.ui.exchangerates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.branovitski.currencyconverter.databinding.FragmentExchangeRatesBinding
import com.branovitski.currencyconverter.model.ExchangeRatesItem
import com.branovitski.currencyconverter.model.ListOfCountries
import com.branovitski.currencyconverter.ui.exchangerates.adapter.ExchangeRatesAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class ExchangeRatesFragment : Fragment() {

    private lateinit var binding: FragmentExchangeRatesBinding

    private val viewModel by viewModels<ExchangeRatesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExchangeRatesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getList()
        viewModel.list.observeForever {
            setList(it)
            ListOfCountries.listOfCountries.addAll(it)
        }

    }

    private fun setList(list: ArrayList<ExchangeRatesItem>) {
        binding.recyclerview.run {
            if (adapter == null) {
                adapter = ExchangeRatesAdapter(requireContext())
                layoutManager = LinearLayoutManager(requireContext())
            }
            (binding.recyclerview.adapter as? ExchangeRatesAdapter)?.setList(list)
        }
    }

}