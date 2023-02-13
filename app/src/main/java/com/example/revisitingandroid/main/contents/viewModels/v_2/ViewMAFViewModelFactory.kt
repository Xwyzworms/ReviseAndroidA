package com.example.revisitingandroid.main.contents.viewModels.v_2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewMAFViewModelFactory(private val startingPoint : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ViewMAFViewModel::class.java))
        {
            return ViewMAFViewModel(startingPoint) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class/")
    }
}