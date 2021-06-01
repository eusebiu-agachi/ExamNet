package com.example.examnet.ui.register

import androidx.lifecycle.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.register.registerModel.RegisterPost
import com.example.examnet.ui.register.registerRepository.RgstrRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel(private val repository: RgstrRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is register Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<Int>> = MutableLiveData()

    fun pushPost(post : RegisterPost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}