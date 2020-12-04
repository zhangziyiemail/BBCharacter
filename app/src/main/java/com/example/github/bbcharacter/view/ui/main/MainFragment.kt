package com.example.github.bbcharacter.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.base.DatabindingFragment
import com.example.github.bbcharacter.databinding.FragmentMainBinding
import com.example.github.bbcharacter.utils.LogUtils
import com.example.github.bbcharacter.view.adapter.CharacterLineAdapter
import com.example.github.bbcharacter.view.ui.detial.CharacterDetailViewModel
import com.example.github.bbcharacter.view.ui.listener
import com.google.android.material.chip.ChipGroup
import org.koin.android.viewmodel.ext.android.getSharedViewModel
import org.koin.android.viewmodel.ext.android.getViewModel
import javax.security.auth.callback.Callback

/**
 *   Created by Lee Zhang on 12/2/20 00:36
 **/
class MainFragment : DatabindingFragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentMainBinding>(inflater, R.layout.fragment_main, container).apply {
            viewModel = getSharedViewModel()
            lifecycleOwner = viewLifecycleOwner
            adapter = CharacterLineAdapter()
            this@MainFragment.binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.svChearceter.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    binding.adapter?.let {
                        it.addCharacterList(getViewModel<MainViewModel>().searchFetchingLiveData(newText))
                    }
                }
                return false
            }
        })
        binding.chipGroup.setOnCheckedChangeListener(object : ChipGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: ChipGroup?, checkedId: Int) {
                if (checkedId == 1){
                    binding.adapter?.let { it.addCharacterList(getViewModel<MainViewModel>().searchSeasonLiveData("") )}

                }else{
                    binding.adapter?.let { it.addCharacterList(getViewModel<MainViewModel>().searchSeasonLiveData((checkedId-1).toString())) }
                }
            }

        })
    }
}




