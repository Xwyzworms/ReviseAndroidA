package com.example.revisitingandroid.main.contents.rooms.rooms_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[Subscriber::class], version=2)
// On database itu abstraksi ( Jadi cuman define method dan variable aja ( Standar database )
abstract class SubscriberDatabase : RoomDatabase() {
    // Basically ini singleton design pattern yak, jadi cuman ada SATU database SUBSCRIBER
    abstract val subscriberDAO : SubscriberDAO
    companion object {
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null

        fun getInstance(context : Context) : SubscriberDatabase
        {
            // Synchronized itu basically dia memastikan hanya ada satu THREAD aja yang bekerja untuk kelas ini !
            synchronized(this)
            {
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(context.applicationContext,
                                                    SubscriberDatabase::class.java,
                                                    "subscriber_data_database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}