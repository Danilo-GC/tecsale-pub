package com.danilo.broker

import com.danilo.model.Product
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import javax.inject.Singleton

@NatsClient
@Singleton
interface ProductClient {

    @Subject("store.product")
    fun send(product: Product)
}