package com.geekysingh.core.architecture.di.component

import android.app.Application
import com.geekysingh.core.architecture.application.CoreApplication
import com.geekysingh.core.architecture.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ServiceModule::class,
        UseCaseModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: CoreApplication)
}