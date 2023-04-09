/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.revisitingandroid.main.contents.workmanagers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ImmediateWorker(appContext : Context, workerParams : WorkerParameters) : Worker(appContext, workerParams){

    override fun doWork(): Result {
        // Do the work here

        return Result.success()
    }
}