package com.danilo.controller

import com.danilo.model.Product
import com.danilo.service.ProductService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Delete
import java.util.UUID


@Controller(value = "/product")
class ProductController(private val productService: ProductService) {

    @Post
    fun addProduct(product: Product): HttpResponse<Product> {
        return HttpResponse.created(productService.addProduct(product))
    }

    @Put(value = "/{id}")
    fun updateProduct(@PathVariable id: String, @Body product: Product): HttpResponse<Product> {
        val convertedId = UUID.fromString(id)
        val updatedProduct = Product(convertedId, product.name, product.price, product.type, product.description)
        return HttpResponse.ok<Product?>().body(productService.updateProduct(convertedId, updatedProduct))
    }

    @Delete(value = "/{id}")
    fun deleteProduct(id: String): HttpResponse<Unit> {
        val convertedId = UUID.fromString(id)
        productService.deleteProduct(convertedId)
        return HttpResponse.noContent()
    }


}
