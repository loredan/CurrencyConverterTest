package ru.loredan13.currencyconvertertest.retrofit.model

import java.math.BigDecimal
import java.time.LocalDate

data class LatestRatesResponse(
    val success: Boolean,
    val timestamp: Long,
    val base: String,
    val date: LocalDate,
    val rates: Map<String, BigDecimal>
) {
    fun toDomainModels() = rates.toList().map {
        ru.loredan13.currencyconvertertest.domain.ExchangeRate(
            base,
            it.first,
            it.second
        )
    }
}