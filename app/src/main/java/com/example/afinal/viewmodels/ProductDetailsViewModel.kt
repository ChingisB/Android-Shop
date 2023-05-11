package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.ProductDetails
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.LikeService
import com.example.afinal.data.retrofit.services.ProductService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.create

class ProductDetailsViewModel: ViewModel() {
    val productDetails = MutableStateFlow<ProductDetails?>(null)
    var errorMessage: String? by mutableStateOf("")
    val service = RetrofitHelper.getInstance().create(ProductService::class.java)

    fun getProduct(productID: Int){
        viewModelScope.launch {
            try {
                productDetails.update { service.getProduct(productID) }
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun likeProduct(){
        viewModelScope.launch {
            try{
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                productDetails.value?.let { likeService.likeProduct(it.id) }
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun deleteLike(){
        viewModelScope.launch {
            try{
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                productDetails.value?.let { likeService.dislikeProduct(it.id) }
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }
}