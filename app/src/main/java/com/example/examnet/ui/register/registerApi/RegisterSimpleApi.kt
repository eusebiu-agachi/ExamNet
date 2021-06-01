package com.example.examnet.ui.register.registerApi

import com.example.examnet.ui.register.registerModel.RegisterPost
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterSimpleApi {

    @POST("http://89.137.141.228:8080/user/register")
    suspend fun pushPost(
        @Body post : RegisterPost
    ): Response<Int>
}