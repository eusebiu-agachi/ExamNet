package com.example.examnet.ui.domenii.Matematica

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.domenii.Matematica.matematicaRepository.MatematicaRepository

class MatematicaViewModelFactory(
    private val repository: MatematicaRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatematicaViewModel(repository) as T
    }
}