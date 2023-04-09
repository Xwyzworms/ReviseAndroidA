/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.workmanagers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class DeferrableOneTimeWorker(context : Context, workerParameters: WorkerParameters ) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        return Result.success()
    }
}

class DeferrablePeriodicWorker(context: Context , workerParameters: WorkerParameters) : Worker(context, workerParameters)
{
    override fun doWork(): Result {


        return Result.success()

    }

}