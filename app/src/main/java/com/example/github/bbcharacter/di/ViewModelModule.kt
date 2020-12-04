package com.example.github.bbcharacter.di

import com.example.github.bbcharacter.view.ui.detial.CharacterDetailViewModel
import com.example.github.bbcharacter.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *   Created by Lee Zhang on 12/1/20 22:43
 **/

val viewModelModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { CharacterDetailViewModel(get()) }
}
