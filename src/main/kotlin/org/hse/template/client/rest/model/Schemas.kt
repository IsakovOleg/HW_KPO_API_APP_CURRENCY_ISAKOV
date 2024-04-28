package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Запрос (ExchangerateApi)")
data class ExchangerateApi(
    @Schema(description = "result")
    var result: String? = "",
    var documentation: String? = "",
    var terms_of_use: String? = "",
    var time_last_update_unix: Int? = 0,
    var time_last_update_utc: String? = "",
    var time_next_update_unix: Int? = 0,
    var time_next_update_utc: String? = "",
    var base_code: String? = "",
    var conversion_rates: Map<String, Float>
)
@Schema(description = "Запрос валюты")
data class Curr(
    @Schema(description = "result")
    var result: String? = "",
    var base_code: String? = "",
    var time_last_update_unix: Int? = 0,
    var time_last_update_utc: String? = "",
    var time_next_update_unix: Int? = 0,
    var time_next_update_utc: String? = "",
    var value: Float = 0.0F,
)
@Schema(description = "Все валюты")
data class AllCurr(
    @Schema(description = "result")
    var result: String? = "",
    var time_last_update_unix: Int? = 0,
    var time_last_update_utc: String? = "",
    var time_next_update_unix: Int? = 0,
    var time_next_update_utc: String? = "",
    var conversion_rates: Map<String, Float>
)
@Schema(description = "История валют")
data class HistCurr(
    @Schema(description = "result")
    var result: String? = "",
    var base_code: String? = "",
    var conversion_rates: Map<String, Float>
)
