package com.branovitski.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.branovitski.currencyconverter.databinding.ActivityMainBinding
import com.branovitski.currencyconverter.ui.calculator.CalculatorFragment
import com.branovitski.currencyconverter.ui.exchangerates.ExchangeRatesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.container, ExchangeRatesFragment())
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.rate -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ExchangeRatesFragment())
                        .commit()
                }
                R.id.calculator -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CalculatorFragment())
                        .commit()
                }
            }
            return@setOnItemSelectedListener true
        }


    }
}