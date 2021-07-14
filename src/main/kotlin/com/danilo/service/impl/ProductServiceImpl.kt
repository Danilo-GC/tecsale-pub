package com.danilo.service.impl

import com.danilo.broker.ProductClient
import com.danilo.model.Product
import com.danilo.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val productClient: ProductClient) : ProductService {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun addProduct(product: Product): Product {
        productClient.sendPost(product)
        log.info("add product sent")
        return product
    }

    override fun updateProduct(product: Product): Product {
        productClient.sendUpdate(product)
        log.info("update product sent")
        return product
    }

    override fun deleteProduct(id: String) {
        productClient.sendDelete(id)
        log.info("delete product sent")
    }
}