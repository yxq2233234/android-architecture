package xyz.yuanxiaoqing.todo.tasks

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.yuanxiaoqing.todo.data.Task

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Task>?) {
    items?.let {
        (listView.adapter as TasksAdapter).submitList(items)
    }
}
