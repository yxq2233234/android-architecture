package xyz.yuanxiaoqing.todo.addedittask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import xyz.yuanxiaoqing.todo.MainActivity
import xyz.yuanxiaoqing.todo.databinding.AddEditTaskFragmentBinding


class AddEditTaskFragment : Fragment(), AddEditTaskListener {

    private lateinit var viewModel: AddEditTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = AddEditTaskViewModel(this)

        val binding = AddEditTaskFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
            lifecycleOwner = this@AddEditTaskFragment
        }

        return binding.root
    }

    override fun onTasksUpdated() {
        (activity as MainActivity).switchTasks()
    }

    override fun onToast(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}
