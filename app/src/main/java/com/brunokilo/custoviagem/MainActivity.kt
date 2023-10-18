package com.brunokilo.custoviagem

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brunokilo.custoviagem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            buttonCalculate.setOnClickListener {
                calculate()
            }
        }

    }

    // Apply não aplicável em Boolean, somente usando .run
    // Aceitei a sugestão do Kotlin e ele gerou o == true
    private fun isValid(): Boolean {
        return (binding?.editDistance?.text?.isNotEmpty() == true
                && binding?.editPrice?.text?.isNotEmpty() == true
                && binding?.editAutonomy?.text?.isNotEmpty() == true)
    }

    private fun calculate() {
        if (isValid()) {
            binding?.apply {
                val distance = editDistance.toFormatFloat()
                val price = editPrice.toFormatFloat()
                val autonomy = editAutonomy.toFormatFloat()
                val totalValue = (distance * price) / autonomy
                textTotalValue.text = totalValue.formatFloat()
            }

            // Toast notification
            // Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }

    private fun Float.formatFloat(): String {
        return "R$ ${"%.2f".format(this)}"
    }

    private fun EditText.toFormatFloat(): Float {
        return this.text.toString().toFloat()
    }

}


