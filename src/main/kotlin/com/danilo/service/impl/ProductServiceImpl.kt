package com.danilo.service.impl

import com.danilo.broker.ProductClient
import com.danilo.model.Product
import com.danilo.service.ProductService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val productClient: ProductClient) : ProductService {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun addProduct(product: Product): Product {
        productClient.send(product)
        log.info("add product send")
        return product
    }

    override fun updateProduct(id: UUID, product: Product): Product {
        productClient.send(product)
        log.info("update product send")
        return product
    }

    override fun deleteProduct(id: UUID) {
        productClient.send(Product(id))
        log.info("delete product send")
    }
}