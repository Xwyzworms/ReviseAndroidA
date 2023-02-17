package com.example.revisitingandroid.main.contents.recyclerViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityRvRecyclerViewsBinding

class RV_RecyclerViewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRvRecyclerViewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvRecyclerViewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()
    }

    private fun setupRv()
    {
        binding.rvMainRECYCLERContent.adapter = RV_RecyclerViewsAdapter(this,provideData(), ::listItemClicked)
        binding.rvMainRECYCLERContent.layoutManager = LinearLayoutManager(this)
    }

    private fun provideData()  : ArrayList<String>
    {
        return arrayListOf<String>(
            "Example-1",
            "Example-2",
            "Example-3",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-4",
            "Example-5",
        )
    }

    private fun listItemClicked(content : String)
    {
        Toast.makeText(this@RV_RecyclerViewsActivity,
        content,
        Toast.LENGTH_SHORT).show()
    }
}