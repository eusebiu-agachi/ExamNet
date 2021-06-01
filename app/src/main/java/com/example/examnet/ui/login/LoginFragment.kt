package com.example.examnet.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.R
import com.example.examnet.StaticClass
import com.example.examnet.ui.login.loginModel.LoginPost
import com.example.examnet.ui.login.loginRepository.LgnRepository
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = LgnRepository()
        val viewModelFactory = LoginViewModelFactory(repository)
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
            var continut1 = email_login.text.toString()
            var continut2 = password_login.text.toString()

            val textView = view.findViewById<TextView>(R.id.text_login)

            continut1.replace(" ", "")
            continut2.replace(" ", "")

            val myPost = LoginPost(email = continut1, password = continut2)
            loginViewModel.pushPost(myPost)
            loginViewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful){
                    mesaj_login.text = "Autentificare efectuată cu succes!"
                    Log.d("CodRaspuns", response.code().toString())
                    Log.d("Parola", response.body()?.password.toString())
                    Log.d("Email", response.body()?.email.toString())
                    Log.d("Username", response.body()?.username.toString())
                    Log.d("Scor", response.body()?.score.toString())

                    StaticClass.email = response.body()?.email.toString()
                    StaticClass.username = response.body()?.username.toString()
                    StaticClass.scor = response.body()?.score.toString()
                    }
                else{
                    mesaj_login.text = "Contul nu există!"
                    Log.d("CodRaspuns", response.code().toString())
                    Log.d("Raspuns", response.body().toString())
                }
            })
        }
    }
}