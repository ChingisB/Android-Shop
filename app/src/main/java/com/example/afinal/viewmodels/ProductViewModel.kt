package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.Product
import com.example.afinal.data.models.product.ProductDetails
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.ProductService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel(){
    val products = MutableStateFlow<List<Product>>(emptyList())
    val product = MutableStateFlow<ProductDetails?>(null)
    var errorMessage: String? by mutableStateOf("")
    private val service = RetrofitHelper.getInstance().create(ProductService::class.java)

    fun getProducts(){
        viewModelScope.launch {
            try {
                products.update { service.getProducts()}
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun getProduct(productID: Int){
        viewModelScope.launch {
            try{
                product.value = service.getProduct(productID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun createProduct(){

    }

    fun updateProduct(){

    }

    fun deleteProduct(){

    }
}