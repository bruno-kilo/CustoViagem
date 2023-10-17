package com.brunokilo.custoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.brunokilo.custoviagem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.root
        setContentView(binding.root)

//        val safeBinding = ActivityMainBinding.inflate(layoutInflater)
//        binding = safeBinding

        binding.buttonCalculate.setOnClickListener {
            calculate()
        }

    }

    private fun isValid(): Boolean {
        (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)

        binding.apply {
            (editDistance.text.toString() != ""
                    && editPrice.text.toString() != ""
                    && editAutonomy.text.toString() != ""
                    && editAutonomy.text.toString().toFloat() != 0f)
        }

        binding.apply {
            return (editDistance.text.isNotEmpty() && editPrice.text.isNotEmpty() && editAutonomy.text.isNotEmpty())
        }
    }

    private fun calculate() {

        if (isValid()) {

//            val distance = binding.editDistance.text.toString().toFloat()
//            val price = binding.editPrice.text.toString().toFloat()
//            val autonomy = binding.editAutonomy.text.toString().toFloat()
//            val totalValue = (distance * price) / autonomy
//            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

            binding.apply {
                val distance = editDistance.toFormmatedFloat()
                val price = editPrice.toFormmatedFloat()
                val autonomy = editAutonomy.toFormmatedFloat()
                val totalValue = (distance * price) / autonomy
//                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
//                textTotalValue.text = getFommatedReal(totalValue)
                textTotalValue.text = totalValue.getFommatedReal()            }


            // Toast notification
            // Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()
        } else {
            isValid()
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }
}

fun getFommatedReal(totalValue: Float): String {
    return "R$ ${"%.2f".format(totalValue)}"
}

fun Float.getFommatedReal(): String {
    return "R$ ${"%.2f".format(this)}"
}

fun EditText.toFormmatedFloat(): Float {
    return this.text.toString().toFloat()
}


