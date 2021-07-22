package ru.loredan13.currencyconvertertest.domain

import io.reactivex.rxjava3.core.Observable
import java.math.BigDecimal

data class ExchangeRate(val from: String, val to: String, val rate: BigDecimal)