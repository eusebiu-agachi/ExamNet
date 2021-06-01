package com.example.examnet.ui.login.loginApi

import com.example.examnet.ui.login.loginUtil.LoginConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetrofitInstance {

    companion object {
        const val BASE_URL = "http://89.137.141.228:8080/user/login"
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(LoginConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: LoginSimpleApi by lazy {
            retrofit.create(LoginSimpleApi::class.java)
        }
    }
}