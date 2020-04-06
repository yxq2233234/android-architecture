package xyz.yuanxiaoqing.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import xyz.yuanxiaoqing.todo.addedittask.AddEditTaskFragment
import xyz.yuanxiaoqing.todo.databinding.ActivityMainBinding
import xyz.yuanxiaoqing.todo.tasks.TasksFragment

class MainActivity : AppCompatActivity() {

    private lateinit var addEditTaskFragment: AddEditTaskFragment
    private lateinit var tasksFragment: TasksFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = MainViewModel()
        binding.apply {
            viewmodel = viewModel
        }

        addEditTaskFragment = AddEditTaskFragment()
        tasksFragment = TasksFragment()

        supportFragmentManager.beginTransaction().add(R.id.fl_root, tasksFragment).commit()
    }

    fun switchToOnCreateTask() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_root, addEditTaskFragment).commit()
    }

    fun switchTasks() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_root, tasksFragment).commit()
    }


}
