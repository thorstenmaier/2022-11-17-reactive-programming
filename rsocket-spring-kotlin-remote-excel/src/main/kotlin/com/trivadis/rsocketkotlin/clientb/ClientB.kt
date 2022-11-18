package com.trivadis.rsocketkotlin.clientb

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.messaging.rsocket.RSocketRequester

@SpringBootApplication
class ClientB(val rsocketRequesterBuilder: RSocketRequester.Builder) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("START B")
        val route = rsocketRequesterBuilder.tcp("localhost", 8181)
            .route("b")
        while(true) {
            route
                .data((Math.random() * 1000).toInt())
                .send().block();
        }
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(ClientB::class.java).web(WebApplicationType.NONE).properties().run()
}