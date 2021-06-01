package com.example.examnet.ui.score

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.MainActivity
import com.example.examnet.R
import com.example.examnet.StaticClass
import com.example.examnet.ui.score.scoreModel.ScorePost
import com.example.examnet.ui.score.scoreRepository.ScoreRepository
import kotlinx.android.synthetic.main.fragment_scope.*

class Score : AppCompatActivity() {

    private lateinit var scoreViewModel : ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_scope)

        val repository = ScoreRepository()
        val viewModelFactory = ScoreViewModelFactory(repository)
        scoreViewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)
        score.text = StaticClass.value

        val myPost = ScorePost(score = StaticClass.value, email = StaticClass.email)
            scoreViewModel.pushPost(myPost)
            scoreViewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Raspuns", response.body().toString())
                    Log.d("Cod", response.code().toString())
                }
            })

        val buttonConfirm = findViewById<Button>(R.id.confirm_score)
        buttonConfirm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}