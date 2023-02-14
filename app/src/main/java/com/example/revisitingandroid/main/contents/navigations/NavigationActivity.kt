package com.example.revisitingandroid.main.contents.navigations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.NvActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    private lateinit var binding : NvActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.nv_activity_navigation)
    }
}