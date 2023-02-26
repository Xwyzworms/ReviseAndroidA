package com.example.revisitingandroid.main.contents.intents.v_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.IntentActivityDataBinding

class Intent_ActivityData : AppCompatActivity() {

    private lateinit var  binding : IntentActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntentActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }


    private fun setupView()
    {
        binding.intentTvV2Namae.text = intent.getStringExtra(NAMAE_EXTRA)
        binding.intentTvV2Age.text = intent.getIntExtra(AGE_EXTRA, -1).toString()
        binding.intentTvV2Hobby.text = intent.getStringExtra(HOBBY_EXTRA)
    }

    companion object {
        const val NAMAE_EXTRA : String = "extra_name";
        const val AGE_EXTRA : String = "extra_age";
        const val HOBBY_EXTRA : String = "extra_hobby"
    }
}