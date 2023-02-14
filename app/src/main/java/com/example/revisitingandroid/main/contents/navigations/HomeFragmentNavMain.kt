package com.example.revisitingandroid.main.contents.navigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.FragmentHomeNavMainBinding
import com.example.revisitingandroid.databinding.NvFragmentHomeBinding

class HomeFragmentNavMain : Fragment() {

    private lateinit var binding : FragmentHomeNavMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home_nav_main, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        }
    private fun provideContents()  : ArrayList<String>
    {
        return arrayListOf(
            "Navigation Example 1"
        )
    }
    private fun setupRecyclerView ()
    {
        binding.rvMainNAVContent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMainNAVContent.adapter = HomeFragmentNavAdapter(this.findNavController(),provideContents())
    }
}