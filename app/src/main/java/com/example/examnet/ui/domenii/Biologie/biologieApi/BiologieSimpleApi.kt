package com.example.examnet.ui.domenii.Biologie.biologieApi

import com.example.examnet.ui.domenii.Biologie.Biologie
import com.example.examnet.ui.domenii.Biologie.biologieModel.BiologieResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BiologieSimpleApi {

    @GET("http://89.137.141.228:8080/biologie")
    suspend fun getInformations(): Response<List<BiologieResponse>>

    @POST("http://89.137.141.228:8080/biologie/query/")
    suspend fun pushPost(@Body post : ArrayList<String>) : Response<Int>
}