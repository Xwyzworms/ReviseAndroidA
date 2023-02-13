package com.example.revisitingandroid.main.contents.livedatas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }


    private fun provideLiveDataMainContents() : ArrayList<String>
    {
        return arrayListOf(
            "Live Data Implementation"
        )
    }
    private fun setupRecyclerView()
    {
        binding.rvMainLVAContent.layoutManager = LinearLayoutManager(this)
        binding.rvMainLVAContent.adapter = LiveDataAdapter(this,provideLiveDataMainContents())
    }
}