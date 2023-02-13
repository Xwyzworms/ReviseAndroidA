package com.example.revisitingandroid.main.contents.viewModels.v_2

import androidx.lifecycle.ViewModel

class ViewMAFViewModel(startingTotal : Int) : ViewModel()
{
    private var  total : Int = 0

    init {
        total = startingTotal
    }

    public fun getTotal() : Int
    {
        return total
    }

    public fun addTotal(input : Int) : Int
    {
        total += input;
        return total
    }

}