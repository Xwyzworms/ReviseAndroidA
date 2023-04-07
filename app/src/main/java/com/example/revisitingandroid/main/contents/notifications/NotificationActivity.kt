package com.example.revisitingandroid.main.contents.notifications

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private val binding : ActivityNotificationBinding get() = _binding!!
    private var _binding : ActivityNotificationBinding? = null

    private val notificationChannelId = "com.rose.blaba.channel1"
    private var notificationName : String = "DemoRoseChannel"
    private var notificationDescription : String = "This is just some Rose description"

    private val notificationChannelIdStranger = "com.rose.blabla.channel2"
    private val notificationGroupStrangerId : String = "com.rose.blabla.group.stranger"
    private var notificationNameStranger : String = "DemoStrangerChannel"
    private var notificationDescriptionStranger : String = "Demo Description fro YEeeet "


    private lateinit var intentRose : Intent
    private lateinit var intentStranger : Intent
    private lateinit var pendingIntentRose : PendingIntent
    private lateinit var pendingIntentStranger : PendingIntent
    private lateinit var notificationMe: NotificationMe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notificationMe = NotificationMe(this)
        setupButtons()
        setupNotification()

        intentRose = Intent(this, RoseNotificationActivity::class.java)
        intentStranger = Intent(this , StrangerNotificationActivity::class.java)
        pendingIntentRose = PendingIntent.getActivity(this,
            NotificationMe.NOTIFICATION_BASIC_ID, intentRose, PendingIntent.FLAG_UPDATE_CURRENT)

        pendingIntentStranger = PendingIntent.getActivity(this,
            NotificationMe.NOTIFICATION_BASIC_ID, intentStranger, PendingIntent.FLAG_UPDATE_CURRENT)
    }


    private fun setupNotification()
    {
        notificationMe.createNotificationChannel(notificationChannelIdStranger, notificationNameStranger, notificationDescriptionStranger)
        notificationMe.createNotificationChannel(notificationChannelId,notificationName,notificationDescription)
    }
    private fun setupButtons ()
    {
        binding.btnNotification.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                displayNotificationRose()
            }
        })

        binding.btnNotificationSecond.setOnClickListener( object : OnClickListener {
            override fun onClick(p0: View?) {
                displayNotificationStranger()
            }
        })
    }

    private fun displayNotificationRose()
    {
        notificationMe.createBasicNotificationRose(
            notificationChannelId, R.drawable.pixel_google, "RoseContent", "RoseText",pendingIntentRose
        )
        notificationMe.createBasicNotificationRose(
            notificationChannelId, R.drawable.pixel_google, "Udah Gatau aku bang", "ITSUKA ? ",pendingIntentRose
        )
    }

    private fun displayNotificationStranger()
    {
        notificationMe.createBasicNotificationStranger(notificationChannelIdStranger, notificationGroupStrangerId, pendingIntentStranger)
    }
}