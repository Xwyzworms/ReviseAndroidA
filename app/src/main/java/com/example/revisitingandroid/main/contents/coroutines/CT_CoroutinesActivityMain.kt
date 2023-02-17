package com.example.revisitingandroid.main.contents.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityCtCoroutinesMainBinding

class CT_CoroutinesActivityMain : AppCompatActivity() {
    private lateinit var binding : ActivityCtCoroutinesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCtCoroutinesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}