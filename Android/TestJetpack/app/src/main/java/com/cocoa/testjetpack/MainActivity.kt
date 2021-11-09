package com.cocoa.testjetpack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.work.*
import com.cocoa.testjetpack.bean.User
import com.cocoa.testjetpack.databinding.ActivityMainBinding
import com.cocoa.testjetpack.lifecycle.LogLifecycleObserver
import com.cocoa.testjetpack.storage.StorageActivity
import com.cocoa.testjetpack.viewModel.MainViewModel
import com.cocoa.testjetpack.viewModel.UserViewModel
import com.cocoa.testjetpack.workManager.UploadWorker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*
import java.util.concurrent.TimeUnit

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class MainActivity : AppCompatActivity() {


    val mainViewModel: MainViewModel by viewModels()
    var binding: ActivityMainBinding? = null

    val userViewModel : UserViewModel by viewModels()


//    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        binding?.user = User("sj","jun")
//        binding?.defaultStr = "the default String"
//        binding?.handler = Handler()
        setContentView(binding?.root)

        binding?.StorageActivity?.setOnClickListener {
            startActivity(Intent(this, StorageActivity::class.java))
        }

        binding?.user = mainViewModel.user
        binding?.defaultStr = "the default String"


        binding?.text2?.setOnClickListener{
            userViewModel.setUser(User("shen","test"))
        }
        userViewModel.getUser().observe(this){
            binding?.text2?.text = it.firstName + it.lastName
        }

        mainViewModel.currentName.observe(this) { value ->

        }
        mainViewModel.currentName.observe(this, nameObserver)
        binding?.btn1?.setOnClickListener {
            changeName()
        }
        lifecycle.addObserver(LogLifecycleObserver(name = "MainActivity"))


        binding?.getWorkManager?.setOnClickListener {

//            WorkRequest 本身是抽象基类。该类有两个派生实现，可用于创建 OneTimeWorkRequest 和 PeriodicWorkRequest 请求。
//            顾名思义，OneTimeWorkRequest 适用于调度非重复性工作，而 PeriodicWorkRequest 则更适合调度以一定间隔重复执行的工作。

            //简单的创建 workRequest
            //val myWorkRequest = OneTimeWorkRequest.from(MyWork::class.java)

            // 如果需要加入别的配置，可以使用构建器    setInitialDelay 延迟
//            var workRequest : WorkRequest = OneTimeWorkRequestBuilder<UploadWorker>().setInitialDelay(10 ,TimeUnit.SECONDS).build()

            // 如果想要创建可以重复执行的workRequest，可以使用 PeriodicWorkRequestBuilder  //可以定义的最短重复间隔是 15 分钟（与 JobScheduler API 相同）。
            var workRequest: PeriodicWorkRequest =
                PeriodicWorkRequestBuilder<UploadWorker>(15, TimeUnit.MINUTES)
                    .addTag("tag1")
                    .build()


            WorkManager.getInstance(this).enqueue(workRequest)


        }

//        val count  = intPreferencesKey("age")
//        val transform: suspend (Preferences) -> Int = {
//            it[count] ?: 0
//        }
//        val map : Flow<Int> = dataStore.data.map(transform)
//        dataStore.edit {
//            it[count] = 11
//        }

    }

    val nameObserver = Observer<String> { newName ->
        // Update the UI, in this case, a TextView.
        binding?.text1?.text = newName
    }


    fun changeName() {
        //您必须调用 setValue(T) 方法以从主线程更新 LiveData 对象。
        // 如果在工作器线程中执行代码，您可以改用 postValue(T) 方法来更新 LiveData 对象。
//        mainViewModel?.currentName.value = "mynameis ${Date().time}"

        Thread {
            Log.i("Mainactivity", "thread")
            mainViewModel.currentName.postValue("mynameis ${Date().time}")
        }.start()


    }

}
