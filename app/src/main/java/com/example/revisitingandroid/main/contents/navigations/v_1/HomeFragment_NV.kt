package com.example.revisitingandroid.main.contents.navigations.v_1

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.NvFragmentHomeBinding

class HomeFragment_NV : Fragment() {

    private lateinit var binding : NvFragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.nv_fragment_home, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    private fun setupView()
    {
        binding.btnNAVV1.setOnClickListener {
            if(!TextUtils.isEmpty(binding.etNAVV1.text.toString()))
            {
                // Bring data
                val bundle : Bundle = bundleOf("etData" to binding.etNAVV1.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_NV_to_secondFragment_NV, bundle)
            }
            else
            {
                Toast.makeText(requireContext(), "Please insert Text", Toast.LENGTH_SHORT).show()
            }
        }

    }

}