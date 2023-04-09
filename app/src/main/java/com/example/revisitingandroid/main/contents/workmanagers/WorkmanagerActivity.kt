package com.example.revisitingandroid.main.contents.workmanagers

import android.content.DialogInterface.OnClickListener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.work.*
import com.example.revisitingandroid.R
import com.example.revisitingandroid.databinding.ActivityWorkmanagerBinding
import com.example.revisitingandroid.main.doToast
import java.util.concurrent.TimeUnit

class WorkmanagerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWorkmanagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkmanagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupOnclickListener()
    }

    private fun setupOnclickListener()
    {
        val btnOneTimeClickListenerImplementation  : View.OnClickListener = View.OnClickListener {
            doToast(this, "OneTimeImmediate")
        }


        binding.btnOneTimeImmediate.setOnClickListener( btnOneTimeClickListenerImplementation )

        //Long Runnnig Implementation
        val btnOneTimeLongRunningClickListenerImplementation  = object : View.OnClickListener
        {
            override fun onClick(p0: View?) {
                doToast(this@WorkmanagerActivity, "OneTimeLongRunning")
            }
        }

        val btnPeriodicLongRunningClickListenerImplementation = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                doToast(this@WorkmanagerActivity, "PeriodicLongRunning")

            }
        }

        val btnOneTimeLongRunningClickListener : View.OnClickListener = btnOneTimeLongRunningClickListenerImplementation
        val btnPeriodicLongRunningClickListener : View.OnClickListener = btnPeriodicLongRunningClickListenerImplementation

        binding.btnOneTimeLongRunning.setOnClickListener( btnOneTimeLongRunningClickListener )
        binding.btnPeriodicLongRunning.setOnClickListener( btnPeriodicLongRunningClickListener )

        //Long Runnnig Implementation END


        class BtnOneTimeDefferableClickListenerImplementation : View.OnClickListener
        {
            override fun onClick(p0: View?) {

                doToast(this@WorkmanagerActivity, "OnetimeDefferable")
            }
        }

        class BtnPeriodicDefferableClickListenerImplementation : View.OnClickListener {
            override fun onClick(p0: View?) {

                doToast(this@WorkmanagerActivity, "PeriodicDefferable")
            }

        }

        val btnOneTimeDefferableClickListener : View.OnClickListener = BtnOneTimeDefferableClickListenerImplementation()
        val btnPeriodicDefferableClickListener : View.OnClickListener = BtnPeriodicDefferableClickListenerImplementation()

        binding.btnOneTimeDeferrable.setOnClickListener(btnOneTimeDefferableClickListener)
        binding.btnPeriodicDeferrable.setOnClickListener(btnPeriodicDefferableClickListener)

    }


    val immediateWorkerData : Data.Builder = Data.Builder().putString(
        IMMEDIATE_KEY, "Hey there, this Immediate"
    )

    val longRunningWorkerData : Data.Builder = Data.Builder().putString(
        LONGRUNNING_KEY, "Hey there this is LongRunning"
    )

    val DefferableWorkerData : Data.Builder = Data.Builder().putString(
        DEFERRABLE_KEY, "Hey there this is Defferable"
    )

    /// WORK REQUEST SECTION, Scheduling ( Only create the schedulee but not submitted yet )
    val immediateWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<ImmediateWorker>()
        .setInputData(immediateWorkerData.build())
        .setExpedited(OutOfQuotaPolicy.DROP_WORK_REQUEST)
        .build()

    // Work Request LongRunning
    val longRunningOnetimeWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<LongRunningWorkerOneTime>()
        .setInputData(longRunningWorkerData.build())
        .setScheduleRequestedAt(10, TimeUnit.SECONDS)
        .build()

    val longRunningPeriodicWorkRequest : WorkRequest = PeriodicWorkRequestBuilder<LongRunningWorkerPeriodic>(
        5, TimeUnit.SECONDS
    ).build()

    //Work request Defereable

    val deferrableOnetimeWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<DeferrableOneTimeWorker>().build()
    val deferrablePeriodicWorkRequest : WorkRequest = PeriodicWorkRequestBuilder<DeferrablePeriodicWorker>(5, TimeUnit.SECONDS).build()


    // SUBMIT to the system
    // Nah i m going to do it later, After done the CameraX
    //TODO
    /*
        Submit the work request to system for each btn listener
        Do refactoring
        Read the data from worker
            Immediate - Simple toast
            LongRunning -> Custom Notification
            Deferrable -> Well Same as longRunning but having pending intent
     */

    companion object {

        const val IMMEDIATE_KEY : String = "IMMEDIATE_KEY"
        const val LONGRUNNING_KEY : String = "LONGRUNNING_KEY"
        const val DEFERRABLE_KEY : String = "DEFERRABLE_KEY"
    }
}