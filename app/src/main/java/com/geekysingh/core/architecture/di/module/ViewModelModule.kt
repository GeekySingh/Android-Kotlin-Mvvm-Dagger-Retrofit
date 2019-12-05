package com.geekysingh.core.architecture.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geekysingh.core.architecture.di.key.ViewModelKey
import com.geekysingh.core.architecture.view.activity.todo.TodoViewModel
import com.geekysingh.core.architecture.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    fun bindTodoViewModels(loginViewModel: TodoViewModel): ViewModel

}