package ru.loredan13.currencyconvertertest.ui

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Flowable
import ru.loredan13.currencyconvertertest.R
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.ExchangeInteractor
import ru.loredan13.currencyconvertertest.domain.ExchangeRate
import ru.loredan13.currencyconvertertest.domain.GetExchangeRateUseCase
import ru.loredan13.currencyconvertertest.presentation.GetExchangeRateUseCaseImpl
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val getExchangeRateUseCase: GetExchangeRateUseCaseImpl
) : AndroidViewModel(application) {
    val preferences = application.getSharedPreferences(PREFERENCES_SAVED_CURRENCY, MODE_PRIVATE)

    val currencyFrom = MutableLiveData(
        Currency.valueOf(
            preferences.getString(KEY_SAVED_CURRENCY_FROM, null) ?: Currency.RUB.name
        )
    )
    val currencyTo = MutableLiveData(
        Currency.valueOf(
            preferences.getString(KEY_SAVED_CURRENCY_TO, null) ?: Currency.USD.name
        )
    )

    val exchangeRate = MediatorLiveData<Pair<Currency, Currency>>().apply {
        addSource(currencyFrom) {
            if (it != null && currencyTo.value != null)
                value = it to currencyTo.value!!
        }
        addSource(currencyTo) {
            if (currencyFrom.value != null && it != null)
                value = currencyFrom.value!! to it
        }
    }.switchMap {
        Flowable.combineLatest(
            getExchangeRateUseCase.getExchangeRate(Currency.EUR, it.first),
            getExchangeRateUseCase.getExchangeRate(Currency.EUR, it.second)
        ) { first, second -> ExchangeRate(first.to, second.to, second.rate / first.rate) }
            .toLiveData()
    }

    val rateString = exchangeRate.map {
        application.resources.getString(R.string.rate, it.from, it.rate, it.to)
    }

    val amountFrom = MutableLiveData("1")
    val amountTo = MediatorLiveData<Pair<BigDecimal, ExchangeRate>>().apply {
        addSource(amountFrom) {
            if (exchangeRate.value != null && it?.toBigDecimalOrNull() != null) {
                value = it.toBigDecimal() to exchangeRate.value!!
            }
        }
        addSource(exchangeRate) {
            if (amountFrom.value?.toBigDecimalOrNull() != null && it != null) {
                value = amountFrom.value!!.toBigDecimal() to it
            }
        }
    }.map { it.first * it.second.rate }

    val fromAdapter = ArrayAdapter(application, R.layout.item_currency, Currency.values().toList())
    val toAdapter = ArrayAdapter(application, R.layout.item_currency, Currency.values().toList())

    val currencyFromOnItemSelectedListener =
        AdapterView.OnItemClickListener { _, _, position, _ ->
            val currency = Currency.values()[position]
            if (currency != currencyFrom.value) {
                currencyFrom.postValue(currency)
                preferences.edit().putString(KEY_SAVED_CURRENCY_FROM, currency.name).apply()
                if (currencyTo.value == currency) {
                    currencyTo.postValue(if (currency != Currency.RUB) Currency.RUB else Currency.USD)
                }
            }
        }

    val currencyToOnItemSelectedListener =
        AdapterView.OnItemClickListener { _, _, position, _ ->
            val currency = Currency.values()[position]
            if (currency != currencyTo.value) {
                currencyTo.postValue(currency)
                preferences.edit().putString(KEY_SAVED_CURRENCY_TO, currency.name).apply()
                if (currencyFrom.value == currency) {
                    currencyFrom.postValue(if (currency != Currency.RUB) Currency.RUB else Currency.USD)
                }
            }
        }

    companion object {
        private const val PREFERENCES_SAVED_CURRENCY = "saved_currency"
        private const val KEY_SAVED_CURRENCY_FROM = "saved_currency_from"
        private const val KEY_SAVED_CURRENCY_TO = "saved_currency_to"
    }
}