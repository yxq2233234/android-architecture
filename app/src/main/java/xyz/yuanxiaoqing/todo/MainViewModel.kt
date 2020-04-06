package xyz.yuanxiaoqing.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val _hello = MutableLiveData<String>("hello")
    val hello: LiveData<String> = _hello

}
