package com.example.examnet.ui.domenii.Matematica.matematicaApi

import com.example.examnet.ui.domenii.Informatica.informaticaApi.InformaticaRetrofitInstance
import com.example.examnet.ui.domenii.Informatica.informaticaApi.InformaticaSimpleApi
import com.example.examnet.ui.domenii.Informatica.informaticaUtil.InformaticaConstants
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
    private val retrofit2 by lazy {
        Retrofit.Builder()
                .baseUrl(MatematicaConstants.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api : MatematicaSimpleApi by lazy {
        retrofit.create(MatematicaSimpleApi::class.java)
    }
    val api2 :MatematicaSimpleApi by lazy {
        MatematicaRetrofitInstance.retrofit2.create(MatematicaSimpleApi::class.java)
    }
}