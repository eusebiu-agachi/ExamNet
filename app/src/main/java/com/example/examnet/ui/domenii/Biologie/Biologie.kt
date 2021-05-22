package com.example.examnet.ui.domenii.Biologie

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.examnet.R

class Biologie : AppCompatActivity() {

    private lateinit var viewModel : BiologieViewModel

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item1)

        val test : TextView = findViewById(R.id.enuntProblema1)
        test.text = "gogo"
    }
}