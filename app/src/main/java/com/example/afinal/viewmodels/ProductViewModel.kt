package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.cart.CartItem
import com.example.afinal.data.models.cart.CreateCart
import com.example.afinal.data.models.cart.CreateCartItem
import com.example.afinal.data.models.product.*
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.CartService
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
import okhttp3.internal.wait
import java.io.File

class ProductViewModel : ViewModel() {
    val products = MutableStateFlow<List<Product>>(emptyList())
    val likedProducts = MutableStateFlow<List<Product>>(emptyList())
    var errorMessage: String? by mutableStateOf("")
    private val service = RetrofitHelper.getInstance().create(ProductService::class.java)
    var category: Category? = null
    var vendor: Vendor? = null
    var minPrice: Int? = null
    var maxPrice: Int? = null

    fun getProducts(name: String? = null) {
        viewModelScope.launch {
            try {
                products.update {
                    service.getProducts(
                        name = name,
                        category = category?.name,
                        vendor = vendor?.name,
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

    fun likeProduct(productID: Int) {
        viewModelScope.launch {
            try {
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                likeService.likeProduct(productID)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun deleteLike(productID: Int) {
        viewModelScope.launch {
            try {
                val likeService = RetrofitHelper.getInstance().create(LikeService::class.java)
                likeService.dislikeProduct(productID)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun setFilter(category: Category?, vendor: Vendor?, minPrice: Int?, maxPrice: Int?) {
        this.category = category
        this.vendor = vendor
        this.minPrice = minPrice
        this.maxPrice = maxPrice
    }

    fun resetFilter() {
        category = null
        vendor = null
        minPrice = null
        maxPrice = null
    }

    fun addToCart(productID: Int) {
        viewModelScope.launch {
            try {
                val cartService = RetrofitHelper.getInstance().create(CartService::class.java)
                val cart = cartService.getCart()
                val createCartItemList = mutableListOf<CreateCartItem>()
                cart.cart.forEach { cartItem ->
                    createCartItemList.add(
                        CreateCartItem(
                            cartItem.product.id,
                            cartItem.quantity
                        )
                    )
                }
                createCartItemList.add(CreateCartItem(productID, 1))
                val createCart = CreateCart(createCartItemList)
                cartService.createCart(createCart)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun getLikedProducts(){
        viewModelScope.launch {
            try{
                likedProducts.update { service.getLikeProducts() }
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun updateProduct() {

    }

    fun deleteProduct(productID: Int) {
        viewModelScope.launch {
            try{
                service.deleteProduct(productID = productID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
        getProducts()
    }
}
