package com.example.revisitingandroid.main.contents.livedatas.v_1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LVA_v1_viewModelFactory(private val startingPoint : Int ) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(LVA_V1_viewModel::class.java))
        {
            return LVA_V1_viewModel(startingPoint) as T
        }
        throw IllegalArgumentException("Unknown Classes")
    }
}