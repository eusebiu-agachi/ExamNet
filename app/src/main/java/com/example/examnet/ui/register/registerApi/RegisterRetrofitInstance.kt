package com.example.examnet.ui.register.registerApi

import com.example.examnet.ui.register.registerUtil.RegisterConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RegisterRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(RegisterConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : RegisterSimpleApi by lazy {
        retrofit.create(RegisterSimpleApi::class.java)
    }
}