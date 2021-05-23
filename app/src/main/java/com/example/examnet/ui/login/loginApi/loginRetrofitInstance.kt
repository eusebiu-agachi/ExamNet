package com.example.examnet.ui.login.loginApi

import com.example.examnet.ui.login.loginUtil.loginConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class loginRetrofitInstance {

    companion object {
        val BASE_URL = "http://89.137.141.228:8080/user/login"
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(loginConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: loginSimpleApi by lazy {
            retrofit.create(loginSimpleApi::class.java)
        }
    }
}