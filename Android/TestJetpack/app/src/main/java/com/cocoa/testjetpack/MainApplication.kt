package com.cocoa.testjetpack

import android.app.Application
import com.cocoa.testjetpack.storage.room.AppDatabase

class MainApplication : Application() {

    val database : AppDatabase by lazy {
        AppDatabase.getInstance(this)
    }

}