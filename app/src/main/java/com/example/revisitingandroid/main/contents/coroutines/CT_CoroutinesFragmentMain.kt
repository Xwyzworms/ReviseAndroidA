package com.example.revisitingandroid.main.contents.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.CtFragmentCoroutinesMainBinding

class CT_CoroutinesFragmentMain : Fragment() {

    private val binding : CtFragmentCoroutinesMainBinding get() = _binding
    private lateinit var _binding : CtFragmentCoroutinesMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CtFragmentCoroutinesMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }
    private fun setupView()
    {
        binding.rvCtCoroutinesMainContent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCtCoroutinesMainContent.adapter = CT_CoroutinesRVMain(provideData(), ::moveIntoAnotherSection)
    }

    private fun moveIntoAnotherSection (position : Int)
    {
        // Using Navigation Here ! Because i am too lazy creating it again and again
        // Should that enough ? Yes Thats enough
        if(position ==0)
        {
            this.findNavController().navigate(R.id.action_CT_CoroutinesFragmentMain_to_fragmentCoroutineFirst)
        }
        else if(position == 1)
        {

            this.findNavController().navigate(R.id.action_CT_CoroutinesFragmentMain_to_fragmentCoroutineSecond)
        }

    }

    private fun provideData() : ArrayList<String>
    {
        return arrayListOf(
            "Coroutine Basic Example",
            "Coroutine Basic Example"
        )
    }
}