package com.example.github.bbcharacter.ViewHolder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *   Created by Lee Zhang on 12/2/20 23:25
 **/
inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy {
        requireNotNull(DataBindingUtil.bind<T>(view)) { "cannot find the matched view to layout." }
    }
