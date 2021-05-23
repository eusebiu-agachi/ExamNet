package com.example.examnet.ui.domenii.Matematica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examnet.ui.domenii.Matematica.matematicaModel.MatematicaResponse
import com.example.examnet.ui.domenii.Matematica.matematicaRepository.MatematicaRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MatematicaViewModel(private val matematicaRepository: MatematicaRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is matematica Fragment"
    }
    val text: LiveData<String> = _text

    val myResponse: MutableLiveData<Response<List<MatematicaResponse>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = matematicaRepository.getInformations()
            myResponse.value = response
        }
    }
}