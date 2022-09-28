package com.lollipop.paymentserver.rsocket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.util.concurrent.Flow.Subscriber

@Controller
class HelloHandler {
    @MessageMapping("test2")
    fun test2(): Flux<String> {
        val list : MutableList<String> = mutableListOf<String>()
        for(i in 1..300) {
            list.add(i.toString())
        }
        return Flux.fromIterable(list)
            .log()
    }
}