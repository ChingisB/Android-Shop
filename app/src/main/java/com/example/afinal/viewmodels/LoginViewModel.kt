package com.example.afinal.viewmodels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.user.User
import com.example.afinal.data.models.user.UserLogin
import com.example.afinal.data.models.user.UserSignUp
import com.example.afinal.data.retrofit.RetrofitHelper
import com.example.afinal.data.retrofit.services.CartService
import com.example.afinal.data.retrofit.services.LoginService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel : ViewModel() {
    // Values required for authentication
    val user = MutableStateFlow<User?>(null)
    var errorMessage by mutableStateOf<String?>("")
    val isAuthenticated = MutableStateFlow<Boolean>(false)
    val status = MutableStateFlow<AuthenticationStatus?>(null)

    // Method is used to login on backend and retrieve token
    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val loginService: LoginService =
                    RetrofitHelper.getInstance().create(LoginService::class.java)
                val userWithToken = loginService.login(UserLogin(username, password))
                user.value = userWithToken.user
                RetrofitHelper.setToken(userWithToken.token)
                isAuthenticated.value = true
                status.value = AuthenticationStatus.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    // Send request to logout and expire the token provided
    fun logout() {
        viewModelScope.launch {
            try {
                val loginService = RetrofitHelper.getInstance().create(LoginService::class.java)
                RetrofitHelper.deleteToken()
                loginService.logout()
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }

    // Method sends request to and endpoint which requires authentication. Resets the token if 401 error is given
    fun checkToken(context: Context) {
        val token = context.getSharedPreferences("ShopPreferences", Context.MODE_PRIVATE)
            .getString("token", null) ?: return
        viewModelScope.launch {
            try {
                RetrofitHelper.setToken(token)
                val cartService = RetrofitHelper.getInstance().create(CartService::class.java)
                cartService.getCart()
                isAuthenticated.value = true
            } catch (e: Exception) {
                if (e is HttpException && e.code() == 401) {
                    RetrofitHelper.deleteToken()
                    isAuthenticated.value = false
                } else {
                    throw e
                }
            }
        }
    }

    fun signUp(username: String, email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            try {
                val loginService = RetrofitHelper.getInstance().create(LoginService::class.java)
                val userWithToken =
                    loginService.signUp(UserSignUp(username, email, password, confirmPassword))
                user.value = userWithToken.user
                RetrofitHelper.setToken(userWithToken.token)
                isAuthenticated.value = true
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }
}

enum class AuthenticationStatus{
    SUCCESS, FAIL
}