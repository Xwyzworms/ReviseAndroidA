package com.example.revisitingandroid.main.contents.coroutines.v_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FCouroutineFirstViewModel : ViewModel() {

    private val _counter : MutableLiveData<Int> = MutableLiveData()
    public val counter : LiveData<Int> get() = _counter

    init {
        _counter.value = 0
    }
    public fun updateCounter()
    {
        _counter.value = _counter.value?.plus(1)
    }


}