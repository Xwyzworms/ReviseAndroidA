/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.revisitingandroid.R

class NotificationMe(private val context : Context) {

    private val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    fun createBasicNotification(
                                channelId: String,
                                iconId : Int,
                                contentTitle : String,
                                contentText : String,
                                pendingIntent: PendingIntent

    ) : Notification
    {
        val notificationBuilder : NotificationCompat.Builder =
            NotificationCompat.Builder(context, channelId )
                .setSmallIcon(iconId)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true) // Remove notification when the user taps

        return notificationBuilder.build()
    }

    fun createBasicGroupNotification(channelId: String, iconId: Int, contentTitle: String,
                                     contentText: String, groupKey : String ,pendingIntent: PendingIntent) : Notification
    {
    val notificationBuilder :  NotificationCompat.Builder = NotificationCompat.Builder(context, channelId).apply {
        setSmallIcon(iconId)
        setContentText(contentText)
        setContentTitle(contentTitle)
        priority = NotificationCompat.PRIORITY_DEFAULT
        setAutoCancel(true)
        setContentIntent(pendingIntent)
        setGroup(groupKey)
    }
        return notificationBuilder.build()
    }
    fun createBasicNotificationRose(channelId : String, iconId: Int, contentTitle: String, contentText: String, pendingIntent: PendingIntent)
    {
        val notification : Notification = createBasicNotification(channelId, iconId,contentTitle,
            contentText,pendingIntent)

        notificationManager.notify(NOTIFICATION_BASIC_ID, notification )
    }

    fun createBasicNotificationStranger(channelId: String, groupChannelId : String ,pendingIntent: PendingIntent)
    {
        createDummyNotificationSForStranger(channelId, groupChannelId)

        val summaryNotifications = NotificationCompat.Builder(context, channelId,).apply {
            setContentText("2 New messages")
            setContentTitle("YEP")
            setSmallIcon(R.drawable.pixel_google)
            setStyle(NotificationCompat.InboxStyle()
                .addLine("Stranger 1 Broo")
                .addLine("Stranger 2 Broo Open up this")
                .setSummaryText("Bro@gmail.com"))
                .setContentIntent(pendingIntent)
                .setGroup(groupChannelId)
                .setGroupSummary(true)
        }.build()
        notificationManager.notify(GROUP_SUMMARY_NOTIFICATION_ID, summaryNotifications)
    }


    fun createDummyNotificationSForStranger(channelId: String, groupChannelId : String)
    {
        val messageNotification1 : Notification = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(R.drawable.pixel_google)
            setContentTitle("Message From Stranger 1")
            setContentText("Hey Andaaa Soal ujian mana ?")
            setGroup(groupChannelId)
        }.build()

        val messageNotification2 : Notification = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(R.drawable.pixel_google)
            setContentTitle("Message from stranger 2")
            setContentText("Broo ada uang gak ? ")
            setGroup(groupChannelId)
        }.build()


        notificationManager.notify(NOTIFICATION_BASIC_ID, messageNotification1)
        notificationManager.notify(STRANGER_NOTIFICATION_ID, messageNotification2)

    }

    fun createNotificationChannel(id : String, name : String, channelDescription : String)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val importance : Int = NotificationManager.IMPORTANCE_DEFAULT

            val notificationChannel : NotificationChannel = NotificationChannel(
                id,name,importance)
            notificationChannel.description = channelDescription
            // Register the channel to system

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    companion object {
        const val NOTIFICATION_BASIC_ID : Int = 0
        const val GROUP_SUMMARY_NOTIFICATION_ID : Int = 100
        const val ROSE_NOTIFICATION_ID : Int = 1
        const val STRANGER_NOTIFICATION_ID : Int = 3
    }
}
