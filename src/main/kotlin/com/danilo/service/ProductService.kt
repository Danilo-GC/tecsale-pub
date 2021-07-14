package com.danilo.service

import com.danilo.model.Product
import javax.inject.Singleton

@Singleton
interface ProductService {

    fun addProduct(product: Product): Product
    fun updateProduct(product: Product): Product
    fun deleteProduct(id: String)
}
