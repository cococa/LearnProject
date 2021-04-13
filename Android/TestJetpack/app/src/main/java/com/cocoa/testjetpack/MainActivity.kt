package com.cocoa.testjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.work.*
import com.cocoa.testjetpack.databinding.ActivityMainBinding
import com.cocoa.testjetpack.lifecycle.LogLifecycleObserver
import com.cocoa.testjetpack.viewModel.MainViewModel
import com.cocoa.testjetpack.workManager.UploadWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {


    val mainViewModel: MainViewModel by viewModels()
    var binding: ActivityMainBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
//        binding?.user = User("sj","jun")
//        binding?.defaultStr = "the default String"
//        binding?.handler = Handler()
        setContentView(binding?.root)

        binding?.user = mainViewModel.user
        binding?.defaultStr = "the default String"

        mainViewModel?.currentName.observe(this) { value ->

        }
        mainViewModel?.currentName.observe(this, nameObserver)
        binding?.btn1?.setOnClickListener {
            changeName()
        }
        lifecycle.addObserver(LogLifecycleObserver(name = "MainActivity"));


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

    }

    val nameObserver = Observer<String> { newName ->
        // Update the UI, in this case, a TextView.
        binding?.text1?.text = newName
    }


    fun changeName() {
        //您必须调用 setValue(T) 方法以从主线程更新 LiveData 对象。
        // 如果在工作器线程中执行代码，您可以改用 postValue(T) 方法来更新 LiveData 对象。
        mainViewModel?.currentName.value = "123"
    }

}
