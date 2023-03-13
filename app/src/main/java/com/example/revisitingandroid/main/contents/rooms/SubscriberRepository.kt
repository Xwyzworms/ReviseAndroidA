package com.example.revisitingandroid.main.contents.rooms

import com.example.revisitingandroid.main.contents.rooms.rooms_db.Subscriber
import com.example.revisitingandroid.main.contents.rooms.rooms_db.SubscriberDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SubscriberRepository(private val dao : SubscriberDAO)
{
    val subscribers = dao.getAllSubscribers()
    suspend fun insert(subscriber: Subscriber)
    {
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: String, email : String)
    {
        dao.updateSubscriber(subscriber, email)
    }

    suspend fun delete(subscriber : Subscriber)
    {
        dao.deleteSubscriber(subscriber)
    }
    suspend fun getUser(strEmail : String) : Subscriber?
    {
           return dao.getUser(strEmail)
    }

    suspend fun deleteAll()
    {
        dao.deleteAll()
    }

}