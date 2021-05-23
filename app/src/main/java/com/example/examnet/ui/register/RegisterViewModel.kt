package com.example.examnet.ui.register


import androidx.lifecycle.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.register.registerModel.registerPost
import com.example.examnet.ui.register.registerRepository.rgstrRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel(private val repository: rgstrRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is register Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<Int>> = MutableLiveData()
    /**
    fun getPost() {
    viewModelScope.launch{
    val response = repository.getPost()
    myResponse.value = response
    }
    }
     */

    fun pushPost(post : registerPost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}