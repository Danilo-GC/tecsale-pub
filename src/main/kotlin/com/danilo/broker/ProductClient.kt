package com.danilo.broker

import com.danilo.model.Product
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import javax.inject.Singleton

@NatsClient
@Singleton
interface ProductClient {

    @Subject("store.product")
    fun sendPost(product: Product)

    @Subject("store.product.update")
    fun sendUpdate(product: Product)

    @Subject("store.product.delete")
    fun sendDelete(id: String)
}