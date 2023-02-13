package com.example.revisitingandroid.main.contents.livedatas.v_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.revisitingandroid.databinding.ActivityLvaV1Binding

class LVA_v1_activity : AppCompatActivity() {
    private lateinit var binding : ActivityLvaV1Binding

    private lateinit var viewModel : LVA_V1_viewModel
    private lateinit var viewModelFactory : LVA_v1_viewModelFactory
    private val startingPoint : Int = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLvaV1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupView()
        bindViewModel()
    }

    private fun setupView ()
    {
        binding.btnLVAV1.setOnClickListener {
            if(binding.etLVAV1.text.isNotEmpty())
            {
                viewModel.updateData(binding.etLVAV1.text.toString().toInt())
            }
        }

    }

    private fun bindViewModel()
    {
        viewModel.getTotal.observe(this, Observer{ value ->
            binding.TVLVAV1.text = value.toString()
        })
    }
    private fun setupViewModel()
    {
        viewModelFactory = LVA_v1_viewModelFactory(startingPoint)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LVA_V1_viewModel::class.java)
    }
}