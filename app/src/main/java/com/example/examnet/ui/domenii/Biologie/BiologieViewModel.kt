package com.example.examnet.ui.domenii.Biologie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.domenii.Biologie.biologieModel.BiologieResponse
import com.example.examnet.ui.domenii.Biologie.biologieRepository.BiologieRepository
import com.example.examnet.ui.domenii.Matematica.matematicaModel.MatematicaResponse
import com.example.examnet.ui.domenii.Matematica.matematicaRepository.MatematicaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class BiologieViewModel(private val biologieRepository: BiologieRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is biologie Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<List<BiologieResponse>>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Int>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = biologieRepository.getInformations()
            myResponse.value = response
        }
    }

    fun pushPost(post : ArrayList<String>) {
        viewModelScope.launch {
            val response = biologieRepository.pushPost(post)
            myResponse2.value = response
        }
    }
}