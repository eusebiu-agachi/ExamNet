package com.example.examnet.ui.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.R
import com.example.examnet.ui.contact.contactModel.ContactPost
import com.example.examnet.ui.contact.contactRepository.ContactRepository
import com.example.examnet.ui.login.loginModel.loginPost
import com.example.examnet.ui.login.loginRepository.lgnRepository
import com.example.examnet.ui.login.loginViewModelFactory
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_login.*

class ContactFragment : Fragment() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = ContactRepository()
        val viewModelFactory = ContactViewModelFactory(repository)
        contactViewModel = ViewModelProvider(this, viewModelFactory).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contact, container, false)
        val textView: TextView = root.findViewById(R.id.text_contact)
        contactViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnConfirm = view.findViewById<Button>(R.id.confirm_contact)
        btnConfirm.setOnClickListener{

            var continut1 = username_contact.text.toString()
            var continut2 = message_contact.text.toString()
            var continut3 =  ratingBar_contact.rating.toInt()

            val textView = view.findViewById<TextView>(R.id.text_contact)

            val myPost = ContactPost(username = continut1, message = continut2, rating = continut3)
            contactViewModel.pushPost(myPost)
            contactViewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Response", response.code().toString())
                    Log.d("raspuns", response.body().toString())
                    Toast.makeText(activity, "Mesajul tau a fost trimis, iti multumim!", Toast.LENGTH_LONG).show()
                }else{
                    Log.d("Response", response.errorBody().toString())
                    textView.text = response.code().toString()
                    Log.d("Rating", continut3.toString());
                    Toast.makeText(activity, textView.text, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}