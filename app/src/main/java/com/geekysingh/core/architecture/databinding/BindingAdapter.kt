package com.geekysingh.core.architecture.databinding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Define binding adapters here
 * An example is given to
 */
@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean?) {
    with(view) {
        visible?.let {
            visibility = if (it) View.VISIBLE
            else View.GONE
        }
    }
}