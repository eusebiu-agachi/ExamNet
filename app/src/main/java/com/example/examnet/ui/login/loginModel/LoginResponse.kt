package com.example.examnet.ui.login.loginModel

data class LoginResponse (
        val id : Int,
        val username : String,
        val email : String,
        val password : String,
        val score : Int
)