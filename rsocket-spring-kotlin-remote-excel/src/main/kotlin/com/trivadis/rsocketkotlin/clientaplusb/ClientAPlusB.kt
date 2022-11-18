package com.trivadis.rsocketkotlin.clientaplusb

import com.trivadis.rsocketkotlin.server.Server
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.messaging.rsocket.RSocketRequester
import java.time.Duration

@SpringBootApplication
class ClientAPlusB(val rsocketRequesterBuilder: RSocketRequester.Builder) : CommandLineRunner {

    override fun run(vararg args: String?) {
        println("START A+B")
        rsocketRequesterBuilder.tcp("localhost", 8181)
            .route("aplusb")
            .retrieveFlux(Integer.TYPE)
            .doOnError { it.printStackTrace() }
            .limitRate(3)
            .delayElements(Duration.ofSeconds(1))
            .subscribe { println("A+B=$it") }
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(ClientAPlusB::class.java).profiles("client").run()
}