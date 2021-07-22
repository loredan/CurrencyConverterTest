package ru.loredan13.currencyconvertertest.presentation

import ru.loredan13.currencyconvertertest.domain.InitInteractor
import javax.inject.Inject

class InitInteractorImpl @Inject constructor(
    private val fetchExchangeRatesUseCase: FetchExchangeRatesUseCaseImpl,
    private val putExchangeRatesUseCase: PutExchangeRatesUseCaseImpl
) : InitInteractor {
    override suspend fun initExchangeRates() {
        fetchExchangeRatesUseCase.fetchExchangeRates().let {
            putExchangeRatesUseCase.putExchangeRates(it)
        }
    }
}