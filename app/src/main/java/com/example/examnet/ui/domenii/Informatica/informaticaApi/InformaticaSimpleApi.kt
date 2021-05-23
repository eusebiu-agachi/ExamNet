package com.example.examnet.ui.domenii.Informatica.informaticaApi

import com.example.examnet.ui.domenii.Informatica.informaticaModel.InformaticaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface InformaticaSimpleApi {

    @GET("http://89.137.141.228:8080/informatica")
    suspend fun getInformations(): Response<List<InformaticaResponse>>

    @POST("http://89.137.141.228:8080/informatica/query/")
    suspend fun pushPost(@Body post : ArrayList<String>) : Response<Int>
}