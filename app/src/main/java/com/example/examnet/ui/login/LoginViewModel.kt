package com.example.examnet.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.login.loginModel.loginPost
import com.example.examnet.ui.login.loginRepository.lgnRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val repository : lgnRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is login Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<Int>> = MutableLiveData()

    fun pushPost(post : loginPost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}