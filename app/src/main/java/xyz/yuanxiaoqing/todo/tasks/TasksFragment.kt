package xyz.yuanxiaoqing.todo.tasks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xyz.yuanxiaoqing.todo.MainActivity
import xyz.yuanxiaoqing.todo.databinding.TasksFragmentBinding

class TasksFragment : Fragment(), TasksListener {

    private lateinit var viewModel: TasksViewModel
    private lateinit var listAdapter: TasksAdapter
    private lateinit var binding: TasksFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = TasksViewModel(this)
        binding = TasksFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
            lifecycleOwner = this@TasksFragment
        }
        setupListAdapter()

        return binding.root
    }

    override fun createTask() {
        (activity as MainActivity).switchToOnCreateTask()
    }

    private fun setupListAdapter() {
        listAdapter = TasksAdapter(viewModel)
        binding.tasksList.adapter = listAdapter
    }
}

