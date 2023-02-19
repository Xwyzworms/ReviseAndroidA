package com.example.revisitingandroid.main.contents.coroutines.v_1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.revisitingandroid.databinding.CtFragmentCoroutineFirstBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentCoroutineFirst : Fragment() {

    private val binding : CtFragmentCoroutineFirstBinding get() = _binding
    private lateinit var _binding : CtFragmentCoroutineFirstBinding
    private lateinit var viewModel : FCouroutineFirstViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CtFragmentCoroutineFirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView()
    {
        viewModel = ViewModelProvider(this).get(FCouroutineFirstViewModel::class.java)
        viewModel.counter.observe(viewLifecycleOwner) {
            binding.ctFirstTvCounter.text=it.toString()
        }
        binding.ctFirstBtn.setOnClickListener{

            for(i in 0..100_000_000)
            {
                Log.d("TAG",i.toString());
            }
        }

        binding.ctFirstBtnCounterCoroutine.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {

                for(i in 0..100_000_000)
                {
                    // Change the CoroutineContext
                    withContext(Dispatchers.Main)
                    {
                        binding.tvCtFirstCoroutineCounter.text = "Current ${i.toString()} executing in ${Thread.currentThread().name}"
                    }
                }
            }

        }

        binding.ctFirstBtnCounter.setOnClickListener {
            viewModel.updateCounter()
        }
    }

}