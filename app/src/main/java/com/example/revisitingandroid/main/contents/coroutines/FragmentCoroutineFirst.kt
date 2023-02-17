package com.example.revisitingandroid.main.contents.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.CtFragmentCoroutineFirstBinding
import com.example.revisitingandroid.databinding.CtFragmentCoroutineSecondBinding

class FragmentCoroutineFirst : Fragment() {

    private val binding : CtFragmentCoroutineFirstBinding get() = _binding
    private lateinit var _binding : CtFragmentCoroutineFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CtFragmentCoroutineFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}