package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.Curr
import org.hse.template.client.rest.model.AllCurr
import org.hse.template.client.rest.model.HistCurr

interface FooApi {

    @Tag(name = "Получение текущих курсов всех доступных валют")
    fun foo(
    ) : AllCurr
    @Tag(name = "Получение текущего курса для конкретной валюты")
    fun foo1(
        @Schema(
            defaultValue = "USD"
        )
        type: String = "USD"
    ) : Curr
    @Tag(name = "Получение исторических данных курса для валюты")
    fun foo2(
        @Schema(
            defaultValue = "USD"
        )
        type: String = "USD"
    ) : HistCurr
}