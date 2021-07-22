package ru.loredan13.currencyconvertertest.retrofit

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalQueries

class LocalDateDeserialiser : JsonDeserializer<LocalDate> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDate {
        return json?.asString?.let {
            DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(it, TemporalQueries.localDate())
        } ?: LocalDate.now()
    }

}