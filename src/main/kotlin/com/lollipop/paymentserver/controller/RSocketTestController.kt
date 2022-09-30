package com.lollipop.paymentserver.controller

import kotlinx.coroutines.flow.Flow
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.messaging.rsocket.retrieveFlow
import org.springframework.messaging.rsocket.retrieveFlux
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDate

@RestController
class RSocketTestController(
    val rSocketRequester: RSocketRequester
) {

    @GetMapping("/rsocket")
    fun test(): Flux<Employees> {
        return rSocketRequester
            .route("requeststream")
            .retrieveFlux<Employees>()
            //.delayElements(Duration.ofNanos(1))
            .take(10)
    }
    @GetMapping("/channel")
    fun test2(): Flux<String> {
        val employees : MutableList<Employees> = mutableListOf()

        for(i in 1..20) {
            employees.add(Employees(i, LocalDate.now(), "No.$i Nam", "JJ", "M", LocalDate.now()))
        }

        return rSocketRequester
            .route("channel")
            .data(Flux.fromIterable(employees))
            .retrieveFlux<String>()
            .take(10)
    }
}