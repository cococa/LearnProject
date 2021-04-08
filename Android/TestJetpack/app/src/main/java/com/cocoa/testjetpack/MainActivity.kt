package com.cocoa.testjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.cocoa.testjetpack.databinding.ActivityMainBinding
import com.cocoa.testjetpack.lifecycle.LogLifecycleObserver
import com.cocoa.testjetpack.viewModel.MainViewModel

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

        mainViewModel?.currentName.observe(this){ value ->

        }
        mainViewModel?.currentName.observe(this, nameObserver)
        binding?.btn1?.setOnClickListener {
            changeName()
        }
        lifecycle.addObserver(LogLifecycleObserver())

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
