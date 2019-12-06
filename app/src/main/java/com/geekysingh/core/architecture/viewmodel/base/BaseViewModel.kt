package com.geekysingh.core.architecture.viewmodel.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAG = "BaseViewModel"

open class BaseViewModel : ViewModel() {

    val apiRequestInProgress = MutableLiveData<Boolean>()
    val title = MutableLiveData<String>()

    init {
        apiRequestInProgress.value = false
    }
}