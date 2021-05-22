package com.example.examnet.ui.register

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
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_register, container, false)
        val textView: TextView = root.findViewById(R.id.text_register)
        registerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonConfirm = view.findViewById<Button>(R.id.singIn_register)
        buttonConfirm.setOnClickListener {
            val textBox1 = view.findViewById<EditText>(R.id.username_register)
            var continut1 = username_register.text.toString()

            val textBox2 = view.findViewById<EditText>(R.id.email_register)
            var continut2 = email_register.text.toString()

            val textBox3 = view.findViewById<EditText>(R.id.password_register)
            var continut3 = password_register.text.toString()

            val textView = view.findViewById<TextView>(R.id.text_register)

            Log.d("asd", continut1)
        }
    }
}