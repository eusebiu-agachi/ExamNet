package com.example.examnet.ui.score

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.examnet.MainActivity
import com.example.examnet.R
import com.example.examnet.StaticClass
import kotlinx.android.synthetic.main.fragment_scope.*

class Score : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_scope)

        score.text = StaticClass.value

        val buttonConfirm = findViewById<Button>(R.id.confirm_score)
        buttonConfirm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}