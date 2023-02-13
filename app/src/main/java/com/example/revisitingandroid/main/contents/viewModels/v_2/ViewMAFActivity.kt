package com.example.revisitingandroid.main.contents.viewModels.v_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.VmactivityViewMafactivityBinding

class ViewMAFActivity : AppCompatActivity() {
    private lateinit var  binding : VmactivityViewMafactivityBinding

    private lateinit var viewModel : ViewMAFViewModel
    private lateinit var viewModelFactory : ViewMAFViewModelFactory
    private val startingPoint : Int =  10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VmactivityViewMafactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupOperation()
    }

    private fun setupViewModel()
    {
        viewModelFactory = ViewMAFViewModelFactory(startingPoint)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewMAFViewModel::class.java)
    }
    private fun setupOperation()
    {
        binding.tvMAF.text = viewModel.getTotal().toString()
        binding.btnMAF.setOnClickListener {
            viewModel.addTotal(binding.etMAF.text.toString().toInt())
            binding.tvMAF.text = viewModel.getTotal().toString()
        }
    }
}