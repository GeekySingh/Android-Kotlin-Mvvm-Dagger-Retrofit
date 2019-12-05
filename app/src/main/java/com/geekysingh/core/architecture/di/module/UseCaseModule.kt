package com.geekysingh.core.architecture.di.module

import com.geekysingh.core.architecture.data.mapper.TodoApiResponseMapper
import com.geekysingh.core.architecture.data.repository.TodoRepository
import com.geekysingh.core.architecture.data.usecase.TodoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideTodoUseCase(repository: TodoRepository, mapper: TodoApiResponseMapper): TodoUseCase {
        return TodoUseCase(repository, mapper)
    }
}