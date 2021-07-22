package ru.loredan13.currencyconvertertest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.loredan13.currencyconvertertest.R
import ru.loredan13.currencyconvertertest.databinding.ActivityMainBinding
import ru.loredan13.currencyconvertertest.domain.Currency
import ru.loredan13.currencyconvertertest.domain.InitInteractor
import ru.loredan13.currencyconvertertest.presentation.InitInteractorImpl
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var initInteractor: InitInteractorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)

        lifecycleScope.launch(CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }) {
            initInteractor.initExchangeRates()
        }
    }
}