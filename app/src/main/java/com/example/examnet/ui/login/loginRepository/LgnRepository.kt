package com.example.examnet.ui.login.loginRepository

import com.example.examnet.ui.login.loginApi.LoginRetrofitInstance
import com.example.examnet.ui.login.loginModel.LoginPost
import com.example.examnet.ui.login.loginModel.LoginResponse
import retrofit2.Response

class LgnRepository {

    suspend fun pushPost(post : LoginPost): Response<LoginResponse> {
        return LoginRetrofitInstance.api.pushPost(post)
    }
}