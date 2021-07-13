package com.danilo.service

import com.danilo.model.Product
import java.util.UUID
import javax.inject.Singleton

@Singleton
interface ProductService {

    fun addProduct(product: Product): Product
    fun updateProduct(id: UUID, product: Product): Product
    fun deleteProduct(id: UUID)
}
