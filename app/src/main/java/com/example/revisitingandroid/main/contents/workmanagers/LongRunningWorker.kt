/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.workmanagers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class LongRunningWorkerOneTime(context : Context, workerParams: WorkerParameters ) : Worker(context, workerParams){
    override fun doWork(): Result {
        // Create the notification !

        return Result.success()
    }
}

class LongRunningWorkerPeriodic(context : Context, workerParams: WorkerParameters ) : Worker(context, workerParams){
    override fun doWork(): Result {
        // Send notification for n Seconds

        return Result.success()
    }
}

