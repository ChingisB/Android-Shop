package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.Category
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.CategoryService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    val categories = MutableStateFlow<List<Category>>(emptyList())
    val category = MutableStateFlow<Category?>(null)
    var errorMessage: String? by mutableStateOf("")
    val service = RetrofitHelper.getInstance().create(CategoryService::class.java)

    fun getCategories() {
        viewModelScope.launch {
            try {
                categories.value = service.getCategories()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun getCategory(categoryID: Int) {
        viewModelScope.launch {
            try {
                category.value = service.getCategory(categoryID = categoryID)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun createCategory(category: Category) {
        viewModelScope.launch {
            try {
                service.createCategory(category)
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    fun updateCategory(categoryID: Int, category: Category) {
        viewModelScope.launch {
            try {
                service.updateCategory(categoryID = categoryID, category = category)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun deleteCategory(categoryID: Int){
        viewModelScope.launch {
            try{
                service.deleteCategory(categoryID = categoryID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }
}