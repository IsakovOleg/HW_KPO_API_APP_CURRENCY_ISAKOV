package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.ExchangerateApi
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "currency", path = "v6/51570157910a778e7e6809e0/latest")
interface Currency {

    @GetMapping("RUB")
    fun random() : ExchangerateApi
}
