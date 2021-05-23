package com.example.examnet.ui.register.registerApi

import com.example.examnet.ui.register.registerModel.registerPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface registerSimpleApi {

    @POST("http://89.137.141.228:8080/user/register")
    suspend fun pushPost(
        @Body post : registerPost
    ): Response<Int>
}