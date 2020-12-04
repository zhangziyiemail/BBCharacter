package com.example.github.bbcharacter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.github.bbcharacter.R

/**
 *   Created by Lee Zhang on 12/2/20 00:37
 **/
abstract class DatabindingFragment : Fragment() {

    protected inline fun <reified T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes resId: Int,
        container: ViewGroup?
    ): T {
        return DataBindingUtil.inflate(inflater, resId, container, false)
    }
}
