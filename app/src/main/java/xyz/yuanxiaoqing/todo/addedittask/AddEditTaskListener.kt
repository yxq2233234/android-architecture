package xyz.yuanxiaoqing.todo.addedittask

interface AddEditTaskListener {
    fun onTasksUpdated()
    fun onToast(msg: String)
}