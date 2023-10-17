package com.brunokilo.custoviagem

import android.widget.EditText

fun getFommatedReal(totalValue: Float): String {
    return "R$ ${"%.2f".format(totalValue)}"
}

fun Float.getFommatedReal(): String {
    return "R$ ${"%.2f".format(this)}"
}

fun EditText.toFormmatedFloat(): Float {
    return this.text.toString().toFloat()
}