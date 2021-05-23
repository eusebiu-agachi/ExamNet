package com.example.examnet.ui.domenii.Informatica.informaticaApi


import com.example.examnet.ui.domenii.Informatica.informaticaUtil.InformaticaConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InformaticaRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(InformaticaConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val retrofit2 by lazy {
        Retrofit.Builder()
                .baseUrl(InformaticaConstants.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val api : InformaticaSimpleApi by lazy {
        retrofit.create(InformaticaSimpleApi::class.java)
    }
    val api2 : InformaticaSimpleApi by lazy {
        InformaticaRetrofitInstance.retrofit2.create(InformaticaSimpleApi::class.java)
    }
}