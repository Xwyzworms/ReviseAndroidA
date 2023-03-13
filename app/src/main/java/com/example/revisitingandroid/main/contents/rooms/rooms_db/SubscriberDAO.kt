package com.example.revisitingandroid.main.contents.rooms.rooms_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO
{
    // Interface // A Contract for the database
    // Apa aja yang bisa dilakukan oleh database yang implementasi kelas ini
    // Menggunakan Suspend karena ya ini bakalan dilakukan di background
    @Insert
    suspend fun insertSubscriber(subscriber : Subscriber) : Long

    @Query("UPDATE subscriber_data_table SET subscriber_name=:subscriber WHERE subscriber_email=:email")
    suspend fun updateSubscriber(subscriber : String, email : String)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("SELECT * FROM subscriber_data_table WHERE subscriber_email=:strEmail" )
    suspend fun getUser(strEmail : String) : Subscriber?

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers() : LiveData<List<Subscriber>>

}