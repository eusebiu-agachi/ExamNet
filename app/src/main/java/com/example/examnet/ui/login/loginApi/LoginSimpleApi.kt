package com.example.examnet.ui.login.loginApi

import com.example.examnet.ui.login.loginModel.LoginPost
import com.example.examnet.ui.login.loginModel.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginSimpleApi {

    @POST("http://89.137.141.228:8080/user/login")
    suspend fun pushPost(@Body post : LoginPost): Response<LoginResponse>
}