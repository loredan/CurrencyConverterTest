package ru.loredan13.currencyconvertertest.domain

import io.reactivex.rxjava3.core.Observable
import java.math.BigDecimal

interface CalculateExchangeUseCase {
    fun calculateExchangeRate(from: BigDecimal): Observable<BigDecimal>
}