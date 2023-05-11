package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.CreateProduct
import com.example.afinal.data.models.product.Product
import com.example.afinal.data.models.product.ProductDetails
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.LikeService
import com.example.afinal.data.retrofit.services.ProductService
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class ProductViewModel : ViewModel() {
    val products = MutableStateFlow<List<Product>>(emptyList())
    var errorMessage: String? by mutableStateOf("")
    private val service = RetrofitHelper.getInstance().create(ProductService::class.java)
    var category: String? = null
    var vendor: String? = null
    var minPrice: Int? = null
    var maxPrice: Int? = null

    fun getProducts(name: String? = null) {
        viewModelScope.launch {
            try {
                products.update {
                    service.getProducts(
                        name = name,
                        category = category,
                        vendor = vendor,
                        minPrice = minPrice,
                        maxPrice = maxPrice
                    )
                }
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun createProduct(createProduct: CreateProduct, images: List<File>) {
        viewModelScope.launch {
            try {
                val productInfoRequestBody = Gson().toJson(createProduct)
                    .toRequestBody("application/json".toMediaTypeOrNull())
                val imagesRequestBody = images.map {
                    val requestFile = it.asRequestBody("image/*".toMediaTypeOrNull())
                    MultipartBody.Part.createFormData("images", it.name, requestFile)
                }
                service.createProduct(productInfoRequestBody, imagesRequestBody)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun likeProduct(productID: Int){
        viewModelScope.launch {
            try{
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                likeService.likeProduct(productID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun deleteLike(productID: Int){
        viewModelScope.launch {
            try{
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                likeService.dislikeProduct(productID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun setFilter(category: String?, vendor: String?, minPrice: Int?, maxPrice: Int?){
        this.category = category
        this.vendor = vendor
        this.minPrice = minPrice
        this.maxPrice = maxPrice
    }

    fun updateProduct() {

    }

    fun deleteProduct() {

    }
}
