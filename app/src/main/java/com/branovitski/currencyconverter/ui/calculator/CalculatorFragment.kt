package com.branovitski.currencyconverter.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.branovitski.currencyconverter.databinding.FragmentCalculatorBinding
import com.branovitski.currencyconverter.model.ListOfCountries
import com.branovitski.currencyconverter.model.ListOfCountries.list2
import com.branovitski.currencyconverter.model.ListOfCountries.map

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

    private val viewModel by viewModels<CalculatorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLists()

        binding.spinner.adapter = ArrayAdapter(
            requireContext(),
            androidx.leanback.R.layout.support_simple_spinner_dropdown_item,
            ListOfCountries.list1
        )

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                ListOfCountries.officialRate = list2[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.calculateButton.setOnClickListener {
            binding.textView.text = viewModel.calculate(
                ListOfCountries.officialRate,
                binding.editText.text.toString().toDouble()
            ).toString()
        }
    }
}