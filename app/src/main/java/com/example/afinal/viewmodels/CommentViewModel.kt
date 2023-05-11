package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.Comment
import com.example.afinal.data.models.product.CreateComment
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.CommentService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommentViewModel: ViewModel(){
    val comments = MutableStateFlow<List<Comment?>>(emptyList())
    var errorMessage: String? by mutableStateOf("")
    private val service: CommentService = RetrofitHelper.getInstance().create(CommentService::class.java)

    fun getComments(productID: Int){
        viewModelScope.launch {
            try{
                comments.value = service.getComments(productID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun createComment(productID: Int, text: String){
        viewModelScope.launch {
            try{
                service.createComment(productID, CreateComment(text))
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
        getComments(productID)
    }
}