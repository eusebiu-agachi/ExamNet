package com.example.examnet.ui.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.ui.contact.contactRepository.ContactRepository



class ContactViewModelFactory (
    private val repository: ContactRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return ContactViewModel(repository) as T
    }
}