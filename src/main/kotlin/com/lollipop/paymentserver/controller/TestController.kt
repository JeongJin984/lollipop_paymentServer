package com.lollipop.paymentserver.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
class TestController {
    @GetMapping("/test3")
    fun test3(): Flux<String> {
        val list : MutableList<String> = mutableListOf<String>()
        for(i in 1..300) {
            list.add(i.toString())
        }
        return Flux.fromIterable(list)
            .delayElements(Duration.ofMillis(1))
            .log()
    }
}