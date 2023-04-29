package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.afinal.data.models.product.Product
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.ProductService
import kotlinx.coroutines.flow.MutableStateFlow

class ProductViewModel: ViewModel(){
    val products = MutableStateFlow<List<Product>>(emptyList())
    val errorMessage: String? by mutableStateOf("")
    private val service = RetrofitHelper.getInstance().create(ProductService::class.java)

    fun getProducts(){

    }

    fun createProduct(){

    }

    fun updateProduct(){

    }

    fun deleteProduct(){

    }
}