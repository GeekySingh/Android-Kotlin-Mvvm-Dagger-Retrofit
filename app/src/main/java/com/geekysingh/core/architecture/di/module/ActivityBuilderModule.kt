package com.geekysingh.core.architecture.di.module

import com.geekysingh.core.architecture.view.activity.todo.TodoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Define all your activities here
 */

@Module(includes = [FragmentBuilderModule::class])
interface ActivityBuilderModule {

    @ContributesAndroidInjector
    fun contributeTodoActivity(): TodoActivity
}