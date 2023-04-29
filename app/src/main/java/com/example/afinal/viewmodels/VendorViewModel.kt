package com.example.afinal.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.product.Vendor
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.VendorService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class VendorViewModel: ViewModel() {
    val vendors = MutableStateFlow<List<Vendor>>(emptyList())
    val vendor = MutableStateFlow<Vendor?>(null)
    var errorMessage: String? by mutableStateOf("")
    val service = RetrofitHelper.getInstance().create(VendorService::class.java)

    fun getVendors(){
        viewModelScope.launch {
            try{
                vendors.value = service.getVendors()
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun getVendor(vendorID: Int){
        viewModelScope.launch {
            try{
                vendor.value = service.getVendor(vendorID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun createVendor(vendor: Vendor){
        viewModelScope.launch {
            try{
                service.createVendor(vendor)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun updateVendor(vendorID: Int, vendor: Vendor){
        viewModelScope.launch {
            try{
                service.updateVendor(vendorID, vendor)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }

    fun deleteVendor(vendorID: Int){
        viewModelScope.launch {
            try{
                service.deleteVendor(vendorID)
            }
            catch (e: Exception){
                errorMessage = e.message
            }
        }
    }
}