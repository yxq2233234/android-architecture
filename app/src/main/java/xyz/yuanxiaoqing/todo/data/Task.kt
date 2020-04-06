package xyz.yuanxiaoqing.todo.data

import java.util.*


data class Task(
    var title: String = "",
    var description: String = "",
    var isCompleted: Boolean = false,
    var id: String = UUID.randomUUID().toString()
)
