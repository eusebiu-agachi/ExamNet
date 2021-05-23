package com.example.examnet.ui.domenii.Informatica

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


import com.example.examnet.ui.domenii.Informatica.informaticaRepository.InformaticaRepository

class InformaticaViewModelFactory2 (
        private val repository: InformaticaRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InformaticaViewModel(repository) as T
    }
}