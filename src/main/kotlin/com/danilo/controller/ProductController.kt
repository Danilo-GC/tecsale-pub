package com.danilo.controller

import com.danilo.model.Product
import com.danilo.service.ProductService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*


@Controller(value = "/product")
class ProductController(private val productService: ProductService) {

    @Post
    fun addProduct(product: Product): HttpResponse<Product> {
        return HttpResponse.created(productService.addProduct(product))
    }

    @Put(value = "/{id}")
    fun updateProduct(@PathVariable id: String, @Body product: Product): HttpResponse<Product> {
        val updatedProduct = Product(UUID.fromString(id), product.name, product.price, product.type, product.description)
        return HttpResponse.ok<Product?>().body(productService.updateProduct (updatedProduct))
    }

    @Delete(value = "/{id}")
    fun deleteProduct(id: String): HttpResponse<Unit> {
        productService.deleteProduct(id)
        return HttpResponse.noContent()
    }


}
