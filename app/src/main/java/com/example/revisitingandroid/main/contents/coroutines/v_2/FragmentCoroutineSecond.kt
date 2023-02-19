package com.example.revisitingandroid.main.contents.coroutines.v_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.CtFragmentCoroutineSecondBinding
import kotlinx.coroutines.*
import kotlin.math.abs

class FragmentCoroutineSecond : Fragment() {

    private val binding : CtFragmentCoroutineSecondBinding get() =_binding
    private lateinit var _binding : CtFragmentCoroutineSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CtFragmentCoroutineSecondBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView()
    {
        binding.btnSecondCoroutine.setOnClickListener {
            // For parallel decomposition
            parallelDecomposition()
        }

        binding.btnSecondFirst.setOnClickListener {
            withoutParallelDecomposition()
        }
    }

    private suspend fun getTheStock1() : Int
    {
        // Delay 10 seconds
        delay(10000)
        return 9000
    }

    private suspend fun getTheStock2() :Int
    {
        //Delay 8 seconds
        delay(8000)
        return 15000
    }

    private  fun withoutParallelDecomposition()
    {

        CoroutineScope(Dispatchers.Main).launch {

        val start : Long = System.currentTimeMillis()

        val stock_1 : Int = getTheStock1()


        val stock_2 : Int  = getTheStock2()


        binding.tvCtSecondStock1.text = stock_1.toString()
        binding.tvCtSecondStock2.text = stock_2.toString()

        val total : Int = stock_1 + stock_2
        val end : Long = System.currentTimeMillis()
        binding.tvCtSecondTime.text = ("Seconds : ${(abs(start - end) /1000).toString()}")
        }
    }
    private fun parallelDecomposition()
    {
        CoroutineScope(Dispatchers.Main).launch {

            val start : Long = System.currentTimeMillis()

            val stock_1 : Deferred<Int> = async(Dispatchers.IO){
              getTheStock1()
            }

            val stock_2 : Deferred<Int> = async(Dispatchers.IO) {
                getTheStock2()
            }

            binding.tvCtSecondStock1Coroutine.text = stock_1.await().toString()
            binding.tvCtSecondStock2Coroutine.text = stock_2.await().toString()

            val total : Int = stock_1.await() + stock_2.await()
            val end : Long = System.currentTimeMillis()
            binding.tvCtSecondTimeCoroutine.text = ("Seconds : ${(abs(start - end)/1000).toString()}")
        }
    }

}