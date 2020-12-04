package com.example.github.bbcharacter.view.ui.detial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.base.DatabindingFragment
import com.example.github.bbcharacter.databinding.FragmentDetailBinding
import com.example.github.bbcharacter.databinding.FragmentMainBinding
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.utils.LogUtils
import com.example.github.bbcharacter.view.adapter.CharacterLineAdapter
import org.koin.android.viewmodel.ext.android.getSharedViewModel

/**
 *   Created by Lee Zhang on 12/3/20 00:38
 **/
class DetailFragment : DatabindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container).apply {

            var bbCharacter =arguments?.getParcelable<BBCharacter>("data")
            character = bbCharacter
            lifecycleOwner = viewLifecycleOwner
        }.root
    }
}