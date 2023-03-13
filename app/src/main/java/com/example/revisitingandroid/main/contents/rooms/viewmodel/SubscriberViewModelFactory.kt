package com.example.revisitingandroid.main.contents.rooms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.revisitingandroid.main.contents.rooms.SubscriberRepository

class SubscriberViewModelFactory(private val repository : SubscriberRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(SubscriberViewmodel::class.java))
        {
            return SubscriberViewmodel(repository) as T
        }

        throw IllegalArgumentException("No Class Name found")
    }
}