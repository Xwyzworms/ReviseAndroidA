package com.example.revisitingandroid.main.contents.viewModels.v_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.revisitingandroid.databinding.VmactivityActivityBinding

class ViewMActivity : AppCompatActivity() {

    private var _binding : VmactivityActivityBinding? = null
    private val binding : VmactivityActivityBinding get() = _binding!!

    private lateinit var viewModel: ViewMAViewModel

    private var counterWithout : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = VmactivityActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewModel()
        setContentView()
        setContentWithoutViewModel()
    }

    private fun setContentView()
    {
        binding.tvVmCounter.text = viewModel.getCount().toString()
        binding.btnVmCounter.setOnClickListener {
            binding.tvVmCounter.text = viewModel.getUpdatedCount().toString()
        }
    }
    private fun setViewModel()
    {
        viewModel = ViewModelProvider(this)[ViewMAViewModel::class.java]
    }

    private fun setContentWithoutViewModel()
    {
        binding.tvVmCounterWithout.text = counterWithout.toString()
        binding.btnVmCounterWithout.setOnClickListener {
            counterWithout++;
            binding.tvVmCounterWithout.text = counterWithout.toString()
        }
    }

}