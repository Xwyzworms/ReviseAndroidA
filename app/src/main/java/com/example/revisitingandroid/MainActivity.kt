package com.example.revisitingandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisitingandroid.databinding.ActivityMainBinding
import com.example.revisitingandroid.main.MainGridAdapter
import com.example.revisitingandroid.main.contents.livedatas.LiveDataActivity
import com.example.revisitingandroid.main.contents.viewModels.ViewModelsActivity

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding ?= null
    private val binding : ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareGridView()
    }

    private fun provideContent() :ArrayList<String>
    {

        return arrayListOf(
            "ViewModel","Live Data","Activity_Fragment","Navigation Arch"
        )
    }

    private fun prepareGridView()
    {
        val adapter : MainGridAdapter = MainGridAdapter(this, provideContent())
        binding.GVMain.adapter = adapter
        var intent : Intent = Intent()
        binding.GVMain.setOnItemClickListener { adapterView, view, position, l ->
            if((provideContent()[position]).lowercase() == "viewmodel")
            {
                intent = Intent(this, ViewModelsActivity::class.java)
            }
            else if((provideContent()[position]).lowercase() == "live data")
            {

                intent = Intent(this, LiveDataActivity::class.java)
            }
            startActivity(intent)
        }
    }


}