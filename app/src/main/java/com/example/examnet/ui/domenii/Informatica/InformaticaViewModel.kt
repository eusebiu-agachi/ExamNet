package com.example.examnet.ui.domenii.Informatica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.domenii.Informatica.informaticaModel.InformaticaResponse
import com.example.examnet.ui.domenii.Informatica.informaticaRepository.InformaticaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class InformaticaViewModel(private val informaticaRepository: InformaticaRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is informatica Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<List<InformaticaResponse>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = informaticaRepository.getInformations()
            myResponse.value = response
        }
    }
}