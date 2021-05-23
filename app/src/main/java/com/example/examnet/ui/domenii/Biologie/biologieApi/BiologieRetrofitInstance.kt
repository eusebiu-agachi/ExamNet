package com.example.examnet.ui.domenii.Biologie.biologieApi

import com.example.examnet.ui.domenii.Biologie.biologieUtil.BiologieConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BiologieRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BiologieConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val retrofit2 by lazy {
        Retrofit.Builder()
            .baseUrl(BiologieConstants.BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : BiologieSimpleApi by lazy {
        retrofit.create(BiologieSimpleApi::class.java)
    }

    val api2 : BiologieSimpleApi by lazy {
        retrofit2.create(BiologieSimpleApi::class.java)
    }
}