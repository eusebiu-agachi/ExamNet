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

    val api : InformaticaSimpleApi by lazy {
        retrofit.create(InformaticaSimpleApi::class.java)
    }
}