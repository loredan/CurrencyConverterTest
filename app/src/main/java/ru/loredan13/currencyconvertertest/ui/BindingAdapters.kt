package ru.loredan13.currencyconvertertest.ui

import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("setTextNoFilter")
    @JvmStatic
    fun setTextNoFilter(autoCompleteTextView: AutoCompleteTextView, text: String) {
        autoCompleteTextView.setText(text, false)
    }
}