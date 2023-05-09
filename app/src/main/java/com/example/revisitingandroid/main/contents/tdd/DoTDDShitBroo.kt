package com.example.revisitingandroid.main.contents.tdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.R

class DoTDDShitBroo : AppCompatActivity() {
    private var score : Int = 0
    var currentScore : Int = score
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do_tddshit_broo)
    }

    fun incrementScore()
    {
        score++;
        currentScore = score
    }

    fun currentScore() : Int
    {
        return currentScore
    }
}