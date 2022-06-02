package com.branovitski.currencyconverter.ui.calculator

import android.annotation.SuppressLint
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
import com.branovitski.currencyconverter.model.ListOfCountries.list1
import com.branovitski.currencyconverter.model.ListOfCountries.list2
import com.branovitski.currencyconverter.model.ListOfCountries.list3
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLists()

        binding.spinner.adapter = ArrayAdapter(
            requireContext(),
            androidx.leanback.R.layout.support_simple_spinner_dropdown_item,
            list1
        )

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                ListOfCountries.officialRate = list3[p2]
                ListOfCountries.abv = list1[p2]
                setTextToCheckBox()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.checkbox.setOnClickListener {
            setTextToCheckBox()
        }

        binding.calculateButton.setOnClickListener {
            if (binding.checkbox.isChecked) {
                binding.textView.text = "= " + viewModel.calculateAnother(
                    ListOfCountries.officialRate,
                    binding.editText.text.toString().toDouble()
                ).toString() + " BUN"
            } else {
                binding.textView.text = "= " + viewModel.calculate(
                    ListOfCountries.officialRate,
                    binding.editText.text.toString().toDouble()
                ).toString() + " " + ListOfCountries.abv
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun setTextToCheckBox() {
        if (binding.checkbox.isChecked) {
            binding.checkbox.text = ListOfCountries.abv + " -> BUN"
        } else {
            binding.checkbox.text = "BUN -> " + ListOfCountries.abv
        }
    }
}