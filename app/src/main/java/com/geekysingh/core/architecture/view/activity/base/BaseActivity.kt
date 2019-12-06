package com.geekysingh.core.architecture.view.activity.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.geekysingh.core.architecture.viewmodel.base.BaseViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

private const val TAG = "BaseActivity"

abstract class BaseActivity<VM : BaseViewModel, VDB : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    protected lateinit var viewModel: VM

    protected lateinit var dataBinding: VDB

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract val bindingVariable: Int

    abstract val viewModelClass: Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        dataBinding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        dataBinding.setVariable(bindingVariable, viewModel)
        dataBinding.executePendingBindings()

        // observe title event
        observeTitleEvent()
        // observe api progress event
        observeApiProgressEvent()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(supportFragmentManager.fragments.size > 0) {
            supportFragmentManager.fragments.forEach {
                it.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    private fun observeTitleEvent() {
        (viewModel as BaseViewModel).title.observe(this, Observer {
            setTitle(it)
        })
    }

    private fun observeApiProgressEvent() {
        (viewModel as BaseViewModel).apiRequestInProgress.observe(this, Observer {
            if(it) {
                // show progress bar
            } else {
                // hide progress bar
            }
        })
    }

    fun setTitle(title: String) {
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(true)
            it.setLogo(null)
            it.title = title
        }
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}