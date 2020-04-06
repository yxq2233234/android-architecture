package xyz.yuanxiaoqing.todo.addedittask

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xyz.yuanxiaoqing.todo.data.Task
import xyz.yuanxiaoqing.todo.data.Tasks

class AddEditTaskViewModel(val addEditTaskListener: AddEditTaskListener) : ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun saveTask(view: View) {
        Log.d("AddEditTaskViewModel", "title = ${title.value} description = ${description.value}")
        if (title.value.isNullOrEmpty() || description.value.isNullOrEmpty()) {
            addEditTaskListener.onToast("标题和描述不能为空！")
            return
        }
        Tasks.tasks = Tasks.tasks + Task(title.value!!, description.value!!)
        addEditTaskListener.onTasksUpdated()
    }


}
