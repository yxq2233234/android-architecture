package xyz.yuanxiaoqing.todo.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.yuanxiaoqing.todo.data.Task
import xyz.yuanxiaoqing.todo.data.Tasks

class TasksViewModel(val tasksListener: TasksListener) : ViewModel() {

    private val _items = MutableLiveData<List<Task>>(Tasks.tasks)
    val items: LiveData<List<Task>> = _items

    fun createTask() {
        tasksListener.createTask()
    }

    fun completeTask(task: Task, completed: Boolean) {
        Tasks.tasks = Tasks.tasks.map {
            if (it == task) {
                it.isCompleted = !completed
            }
            it
        }
    }
}
