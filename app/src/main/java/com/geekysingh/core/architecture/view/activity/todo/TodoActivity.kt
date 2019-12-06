package com.geekysingh.core.architecture.view.activity.todo

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.geekysingh.core.architecture.BR
import com.geekysingh.core.architecture.R
import com.geekysingh.core.architecture.common.logger.Logger
import com.geekysingh.core.architecture.databinding.ActivityTodoBinding
import com.geekysingh.core.architecture.view.activity.base.BaseActivity

private const val TAG = "TodoActivity"

class TodoActivity : BaseActivity<TodoViewModel, ActivityTodoBinding>() {

    override val layoutRes = R.layout.activity_todo
    override val bindingVariable = BR.viewModel
    override val viewModelClass = TodoViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // register observer
        observeTodoDataFailureEvent()
    }

    private fun observeTodoDataFailureEvent() {
        viewModel.todoDataFailureEvent.observe(this, Observer {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
            Logger.Error(TAG, "Todo data fetch failed -> $it")
        })
    }
}