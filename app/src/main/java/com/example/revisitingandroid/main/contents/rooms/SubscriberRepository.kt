package com.example.revisitingandroid.main.contents.rooms

import com.example.revisitingandroid.main.contents.rooms.rooms_db.Subscriber
import com.example.revisitingandroid.main.contents.rooms.rooms_db.SubscriberDAO

class SubscriberRepository(private val dao : SubscriberDAO)
{
    val subscribers = dao.getAllSubscribers()
    suspend fun insert(subscriber: Subscriber)
    {
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber)
    {
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber : Subscriber)
    {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll()
    {
        dao.deleteAll()
    }

}