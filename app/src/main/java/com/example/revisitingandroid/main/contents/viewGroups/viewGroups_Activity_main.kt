package com.example.revisitingandroid.main.contents.viewGroups

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityViewGroupsMainBinding

class viewGroups_Activity_main : AppCompatActivity() {
    private lateinit var binding : ActivityViewGroupsMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewGroupsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}