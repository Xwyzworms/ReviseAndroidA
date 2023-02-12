package com.example.revisitingandroid.main.contents.viewModels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.databinding.VmactivityViewModelsBinding

class ViewModelsActivity : AppCompatActivity() {

    private var _binding : VmactivityViewModelsBinding ?=null
    private val binding : VmactivityViewModelsBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = VmactivityViewModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()

    }

    private fun provideListContents() : ArrayList<String>
    {
        return arrayListOf<String>(
            "viewModelWhy",
            "viewModelFactory"
        )
    }

    private fun setupRecyclerView()
    {
        binding.rvViewModelContents.layoutManager = LinearLayoutManager(this)
        binding.rvViewModelContents.adapter = ViewModelsAdapter(this,provideListContents())

    }
}