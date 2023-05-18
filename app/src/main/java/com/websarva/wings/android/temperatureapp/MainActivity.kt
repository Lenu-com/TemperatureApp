package com.websarva.wings.android.temperatureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCelsius: TextView = findViewById(R.id.tvCelsius)
        val tvFahrenheit: TextView = findViewById(R.id.tvFahrenheit)
        val etCelsius: EditText? = findViewById(R.id.etCelsius)
        val btConvert: Button = findViewById(R.id.btConvert)
        var tvConvertFahrenheit: TextView = findViewById(R.id.tvConvertFahrenheit)

        btConvert.setOnClickListener {
            val celsius = createCelsiusBigDecimal(etCelsius)
            val fahrenheitText = fahrenheitToString(convertCelsiusToFahrenheit(celsius))
            tvConvertFahrenheit.text = fahrenheitText
        }
    }

    private fun createCelsiusBigDecimal(etCelsius: EditText?): BigDecimal {
        if (etCelsius == null) return BigDecimal("0")
        return BigDecimal(etCelsius.text.toString())
    }

    private fun convertCelsiusToFahrenheit(celsiusBigDecimal: BigDecimal): BigDecimal {
        return  celsiusBigDecimal * BigDecimal("1.8") + BigDecimal("32")
    }

    private fun fahrenheitToString(fahrenheit: BigDecimal): String {
        return fahrenheit.toString()
    }
}