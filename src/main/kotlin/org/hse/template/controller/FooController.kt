package org.hse.template.controller

import io.swagger.v3.oas.annotations.media.Schema
import org.hse.template.api.FooApi
import org.hse.template.client.rest.api.Currency
import org.hse.template.client.rest.model.Curr
import org.hse.template.client.rest.model.AllCurr
import org.hse.template.client.rest.model.HistCurr
import org.hse.template.jdbc.Jdbc
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
@RestController
class FooController(
    private val currency: Currency,
    private val jdbc: Jdbc
) : FooApi {

    @GetMapping("/rates")
    override fun foo(): AllCurr {
        val api = currency.random()
        val conv = mutableMapOf<String, Float>()
        for ((k, v) in api.conversion_rates) {
            conv[k] = 1 / v
        }
        return AllCurr(result = api.result, time_last_update_unix = api.time_last_update_unix, time_last_update_utc = api.time_last_update_utc, time_next_update_unix = api.time_next_update_unix, time_next_update_utc = api.time_next_update_utc, conversion_rates = conv)
    }

    @GetMapping("/rate")
    override fun foo1(@Schema(defaultValue = "USD") type: String): Curr {
        val api = currency.random()
        var cur = 0.0F
        if (api.conversion_rates.containsKey(type)) {
            cur = 1 / api.conversion_rates[type]!!
        } else {
            return Curr(result = "Failure")
        }
        return Curr(result = api.result, time_last_update_unix = api.time_last_update_unix, time_last_update_utc = api.time_last_update_utc, time_next_update_unix = api.time_next_update_unix, time_next_update_utc = api.time_next_update_utc, value = cur)
    }

    @GetMapping("/history")
    override fun foo2(@Schema(defaultValue = "USD") type: String): HistCurr {
        val api = currency.random()
        if (jdbc.hist(type)) {
            return HistCurr(result = "Error", conversion_rates = api.conversion_rates)
        }
        return HistCurr(result = api.result, conversion_rates = api.conversion_rates)
    }
}