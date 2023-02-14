package com.example.revisitingandroid.main.contents.navigations.v_1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.NvFragmentSecondBinding

class SecondFragment_NV : Fragment() {

    private lateinit var binding : NvFragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.nv_fragment_second, container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!TextUtils.isEmpty(arguments?.getString("etData")))
        {
            binding.tvNAVV11.text = arguments?.getString("etData")
        }
    }
}