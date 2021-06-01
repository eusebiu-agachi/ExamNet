package com.example.examnet.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.login.loginModel.LoginPost
import com.example.examnet.ui.login.loginModel.LoginResponse
import com.example.examnet.ui.login.loginRepository.LgnRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val repository : LgnRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is login Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<LoginResponse>> = MutableLiveData()

    fun pushPost(post : LoginPost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}