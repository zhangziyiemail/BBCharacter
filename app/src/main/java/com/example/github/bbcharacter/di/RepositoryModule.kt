package com.example.github.bbcharacter.di

import com.example.github.bbcharacter.repository.DetailRepository
import com.example.github.bbcharacter.repository.MainRepository
import org.koin.dsl.module

/**
 *   Created by Lee Zhang on 12/1/20 22:15
 **/

val repositoryModule = module {

    single { MainRepository(get(), get()) }

    single { DetailRepository(get()) }
}
