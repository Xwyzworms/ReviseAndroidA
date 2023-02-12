package com.example.revisitingandroid.main.contents.viewModels.v_1

import androidx.lifecycle.ViewModel

class ViewMAViewModel : ViewModel() {

    private var count : Int = 0;

    public fun getCount() : Int
    {
        return count
    }

    fun getUpdatedCount() :Int
    {
        return ++count;
    }
}