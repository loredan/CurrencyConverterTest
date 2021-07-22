package ru.loredan13.currencyconvertertest.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DB::class.java, "db").build()

    @Singleton
    @Provides
    fun provideExchangeRatesDao(db: DB) = db.exchangeRateDao()
}