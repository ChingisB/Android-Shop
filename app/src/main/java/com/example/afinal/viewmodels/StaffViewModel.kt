package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.user.User
import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.StaffService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class StaffViewModel: ViewModel() {
    val staffList = MutableStateFlow<List<User>>(listOf())
    var errorMessage: String? by mutableStateOf("")
    var staffService: StaffService = RetrofitHelper.getInstance().create(StaffService::class.java)

    fun getStaff(){
        viewModelScope.launch {
            try{
                staffList.value = staffService.getAllStaff()
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun createStaff(signUp: UserSignUp){
        viewModelScope.launch {
            try{
                staffService.createStaff(signUp)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun deleteStaff(staffID: Int){
        viewModelScope.launch {
            try{
                staffService.deleteStaff(staffID = staffID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }
}