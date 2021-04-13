package com.cocoa.testjetpack.workManager

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(var context: Context, var workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {




        var list = MutableList<Int>(10) { i -> i }
        list.forEach {
            Thread.sleep(1000)
            Log.d("-UploadWorker-", "-UploadWorker-i am UploadWorker-")
        }

        return Result.success()
    }
}