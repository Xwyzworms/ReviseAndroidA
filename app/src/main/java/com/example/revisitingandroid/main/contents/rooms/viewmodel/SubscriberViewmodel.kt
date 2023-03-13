package com.example.revisitingandroid.main.contents.rooms.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.revisitingandroid.main.contents.rooms.SubscriberRepository
import com.example.revisitingandroid.main.contents.rooms.rooms_db.Subscriber
import kotlinx.coroutines.*

class SubscriberViewmodel(private val repository: SubscriberRepository) : ViewModel()
{
    val subscribers = repository.subscribers

    // Input to insert and delete

    val inputName : MutableLiveData<String> = MutableLiveData<String>()
    val inputEmail : MutableLiveData<String> = MutableLiveData<String>()

    val saveOrUpdateButtonText : MutableLiveData<String> = MutableLiveData<String>()
    val clearAllOrDeleteButtonText : MutableLiveData<String> = MutableLiveData<String>()
    public fun saveOrUpdate()
    {
        /// save or update the Subscriber
        val name = inputName.value
        val email = inputEmail.value
        if(name != null && email != null)
        {
            insert(Subscriber(0, name,email))
            inputName.value = ""
            inputEmail.value =""
        }

    }

    public fun getUser(userEmail : String)  : Boolean
    {
        var flag : Boolean = false;
        runBlocking(Dispatchers.IO) {
            if(repository.getUser(userEmail) != null)
                {
                    val defferedFlag = async {
                        flag  = true
                    };

                    defferedFlag.await()
                }
        }
    return flag
    }

    public fun clearAllOrDelete()
    {
        if(saveOrUpdateButtonText.value == "Save")
        {

        }
    }

    public fun insert(subscriber : Subscriber)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insert(subscriber)
        }
    }

    public fun update(subscriber: String, email : String)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            Log.d("ASSERTSh", "DOUBLE")
            repository.update(subscriber,email)
        }
    }

    public fun delete(subscriber: Subscriber)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.delete(subscriber)
        }
    }

    public fun clearAll() = viewModelScope.launch(Dispatchers.IO)
    {
        repository.deleteAll()
    }
}