package com.example.revisitingandroid.main.contents.livedatas.v_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LVA_V1_viewModel(private val startingPoint : Int) : ViewModel()
{
    private val total : MutableLiveData<Int> = MutableLiveData(startingPoint)
    val getTotal : LiveData<Int> get() = total

    fun updateData(data : Int)
    {
        total.value = total.value?.plus(data)
    }
}