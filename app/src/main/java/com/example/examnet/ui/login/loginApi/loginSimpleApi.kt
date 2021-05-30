package com.example.examnet.ui.login.loginApi

import com.example.examnet.ui.login.loginModel.loginPost
import com.example.examnet.ui.login.loginModel.loginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface loginSimpleApi {

    @POST("http://89.137.141.228:8080/user/login")
    suspend fun pushPost(@Body post : loginPost): Response<loginResponse>
}