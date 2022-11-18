package com.trivadis.rsocketkotlin.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks
import reactor.core.publisher.Sinks

@SpringBootApplication
class Server

fun main(args: Array<String>) {
    Hooks.onErrorDropped {}
    SpringApplicationBuilder(Server::class.java).profiles("server").run()
}

@Controller
class ServerController {

    val aSink = Sinks.many().replay().latest<Int>()
    val bSink = Sinks.many().replay().latest<Int>()

    @MessageMapping("a")
    fun setA(a: Int) {
        println("A=$a")
        aSink.tryEmitNext(a)
    }

    @MessageMapping("b")
    fun setB(b: Int) {
        println("B=$b")
        bSink.tryEmitNext(b)
    }

    @MessageMapping("aplusb")
    fun getAPlusB(): Flux<Int> {
        return Flux.combineLatest(aSink.asFlux().startWith(0), bSink.asFlux().startWith(0)) { t, u -> t + u }
    }
}