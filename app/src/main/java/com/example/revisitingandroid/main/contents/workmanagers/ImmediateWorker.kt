/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.workmanagers

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.revisitingandroid.R
import com.example.revisitingandroid.main.contents.notifications.NotificationMe
import com.example.revisitingandroid.main.contents.notifications.RoseNotificationActivity
import com.example.revisitingandroid.main.doToast

class ImmediateWorker(private val appContext : Context, private val workerParams : WorkerParameters) : Worker(appContext, workerParams){
    private val notificationChannelId = "com.rose.blaba.channel1"
    private var notificationName : String = "DemoRoseChannel"
    private var notificationDescription : String = "This is just some Rose description"

    override fun doWork(): Result {
        val inputedData : String? = inputData.getString(WorkmanagerActivity.IMMEDIATE_KEY)
        if(inputedData != null)
        {
            val intent = Intent(appContext, RoseNotificationActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(appContext, NotificationMe.NOTIFICATION_BASIC_ID,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

            NotificationMe(appContext).createBasicNotificationRose(notificationChannelId, R.drawable.pixel_google,"HEYY", inputedData, pendingIntent )
        }
        else
        {
            // Cannot do toast therefore just do shit
        }

        return Result.success()
    }
}