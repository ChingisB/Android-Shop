package com.example.afinal.viewmodels

import androidx.lifecycle.ViewModel
import com.example.afinal.data.models.product.ProductDetails
import kotlinx.coroutines.flow.MutableStateFlow

class ProductDetailsViewModel: ViewModel() {
    val productDetails = MutableStateFlow<ProductDetails?>(null)
    var errorMessage =
}