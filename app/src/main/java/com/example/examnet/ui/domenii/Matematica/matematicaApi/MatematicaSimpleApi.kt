package com.example.examnet.ui.domenii.Matematica.matematicaApi

import com.example.examnet.ui.domenii.Matematica.matematicaModel.MatematicaResponse
import retrofit2.Response
import retrofit2.http.GET

interface MatematicaSimpleApi {

    @GET("http://89.137.141.228:8080/matematica")
    suspend fun getInformations(): Response<List<MatematicaResponse>>
}