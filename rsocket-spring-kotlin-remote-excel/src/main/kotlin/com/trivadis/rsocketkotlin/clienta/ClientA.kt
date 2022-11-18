package com.trivadis.rsocketkotlin.clienta

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.messaging.rsocket.RSocketRequester
import org.springframework.stereotype.Component
import reactor.core.Disposable
import reactor.core.publisher.Hooks
import javax.print.attribute.IntegerSyntax

@SpringBootApplication
class ClientA(val rsocketRequesterBuilder: RSocketRequester.Builder) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("START A")
        rsocketRequesterBuilder.tcp("localhost", 8181)
            .route("a")
            .data((Math.random() * 1000).toInt())
            .send().block();
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(ClientA::class.java).web(WebApplicationType.NONE).properties().run()
}