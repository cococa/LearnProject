package com.cocoa.testjetpack.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LogLifecycleObserver(var name : String) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onCreate(){
        Log.d("---","${name}--onCreate----")
    }


}