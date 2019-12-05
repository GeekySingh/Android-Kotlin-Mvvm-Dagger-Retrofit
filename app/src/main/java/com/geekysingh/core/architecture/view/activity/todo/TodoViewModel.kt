package com.geekysingh.core.architecture.view.activity.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.geekysingh.core.architecture.common.liveevent.SingleLiveEvent
import com.geekysingh.core.architecture.data.model.TodoModel
import com.geekysingh.core.architecture.data.usecase.TodoUseCase
import com.geekysingh.core.architecture.domain.remote.response.ErrorResponse
import com.geekysingh.core.architecture.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel @Inject constructor(private val useCase: TodoUseCase) : BaseViewModel() {

    val todoId = MutableLiveData<String>()
    val todoData = MutableLiveData<TodoModel>()
    val todoDataFailureEvent = SingleLiveEvent<ErrorResponse>()

    fun getTodoData(todoId : String) {
        // mark api request in progress to true
        apiRequestInProgress.value = true
        // launch coroutines within viewmodel scope
        viewModelScope.launch {
            // get data from network
            val response = useCase.getTodoList(Integer.parseInt(todoId))
            // check network response
            if(response.isSuccessful) {
                // set data value
                todoData.value = response.data
            } else {
                // notify error event
                todoDataFailureEvent.value = response.errorResponse
            }
            // mark api request in progress to false
            apiRequestInProgress.value = true
        }
    }
}