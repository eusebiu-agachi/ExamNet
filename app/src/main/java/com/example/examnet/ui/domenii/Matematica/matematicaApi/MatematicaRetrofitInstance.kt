package com.example.examnet.ui.domenii.Matematica.matematicaApi

import com.example.examnet.ui.domenii.Matematica.matematicaUtil.MatematicaConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MatematicaRetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(MatematicaConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : MatematicaSimpleApi by lazy {
        retrofit.create(MatematicaSimpleApi::class.java)
    }
}