package com.example.examnet.ui.domenii.Matematica

import android.app.MediaRouteActionProvider
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.R
import com.example.examnet.ui.domenii.Matematica.matematicaModel.MatematicaResponse
import com.example.examnet.ui.domenii.Matematica.matematicaRepository.MatematicaRepository
import kotlinx.android.synthetic.main.activity_item1.*

class Matematica : AppCompatActivity() {

    private lateinit var viewModel : MatematicaViewModel

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item1)

        val repository = MatematicaRepository()
        val viewModelfactory = MatematicaViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelfactory).get(MatematicaViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                //Log.d("test", response.body().toString())
                val problemsArray : List<Any> = response.body() as List<Any>
                for (i in problemsArray.indices) {
                    Log.d(i.toString(), problemsArray[i].toString())
                }

                enuntProblema1.text = (problemsArray[0] as MatematicaResponse).enunt
                enuntProblema2.text = (problemsArray[1] as MatematicaResponse).enunt
                enuntProblema3.text = (problemsArray[2] as MatematicaResponse).enunt
                enuntProblema4.text = (problemsArray[3] as MatematicaResponse).enunt
                enuntProblema5.text = (problemsArray[4] as MatematicaResponse).enunt
                enuntProblema6.text = (problemsArray[5] as MatematicaResponse).enunt
                enuntProblema7.text = (problemsArray[6] as MatematicaResponse).enunt
                enuntProblema8.text = (problemsArray[7] as MatematicaResponse).enunt
                enuntProblema9.text = (problemsArray[8] as MatematicaResponse).enunt
                enuntProblema10.text = (problemsArray[9] as MatematicaResponse).enunt
            }
        })

        val test : TextView = findViewById(R.id.enuntProblema1)
        test.text = "gogo"
    }
}