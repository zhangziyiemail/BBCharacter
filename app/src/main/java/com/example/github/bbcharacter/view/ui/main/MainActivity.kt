package com.example.github.bbcharacter.view.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.base.DatabindingActivity
import com.example.github.bbcharacter.databinding.ActivityMainBinding
import com.example.github.bbcharacter.extensions.applyExitMaterialTransform
import org.koin.android.viewmodel.ext.android.getViewModel

/**
 *   Created by Lee Zhang on 12/1/20 23:12
 **/

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        applyExitMaterialTransform()
        super.onCreate(savedInstanceState)
        binding.apply {
        }
    }


}
