package com.geekysingh.core.architecture.di.module

import com.geekysingh.core.architecture.domain.service.TodoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideTodoService(retrofit: Retrofit) : TodoService {
        return retrofit.create(TodoService::class.java)
    }
}