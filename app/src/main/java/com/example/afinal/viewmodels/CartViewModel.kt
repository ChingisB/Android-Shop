package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.cart.Cart
import com.example.afinal.data.models.cart.CreateCart
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.CartService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel: ViewModel() {
    val cart = MutableStateFlow<Cart?>(null)
    var errorMessage: String? by mutableStateOf("")
    val service = RetrofitHelper.getInstance().create(CartService::class.java)

    fun getCart(){
        viewModelScope.launch {
            try{
                cart.update { service.getCart() }
            }
            catch(e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun createCart(createCart: CreateCart){
        viewModelScope.launch {
            try{
                service.createCart(createCart)
            }
            catch(e: Exception){
                errorMessage = e.message
            }
        }
    }
}