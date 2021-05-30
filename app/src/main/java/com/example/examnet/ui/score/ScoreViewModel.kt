package com.example.examnet.ui.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.score.scoreModel.ScorePost
import com.example.examnet.ui.score.scoreRepository.ScoreRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ScoreViewModel (private val repository : ScoreRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is score fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<String>> = MutableLiveData()

    fun pushPost(post : ScorePost) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}