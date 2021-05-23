package com.example.examnet.ui.login

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
import com.example.examnet.ui.login.loginModel.loginPost
import com.example.examnet.ui.login.loginRepository.lgnRepository
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = lgnRepository()
        val viewModelFactory = loginViewModelFactory(repository)
        loginViewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        val textView: TextView = root.findViewById(R.id.text_login)
        loginViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonConfirm = view.findViewById<Button>(R.id.singIn_login)
        buttonConfirm.setOnClickListener{
            var textBox1 = view.findViewById<EditText>(R.id.email_login)
            var textBox2 = view.findViewById<EditText>(R.id.password_login)

            var continut1 = email_login.text.toString()
            var continut2 = password_login.text.toString()

            val textView = view.findViewById<TextView>(R.id.text_login)

            val myPost = loginPost(email = continut1, password = continut2)
            loginViewModel.pushPost(myPost)
            loginViewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Response", response.code().toString())
                    Log.d("raspuns", response.body().toString())
                    Toast.makeText(activity, "Autentificare reușită", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

}