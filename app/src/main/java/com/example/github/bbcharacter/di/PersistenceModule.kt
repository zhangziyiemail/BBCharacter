package com.example.github.bbcharacter.di

import androidx.room.Room
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.persistence.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 *   Created by Lee Zhang on 12/1/20 22:12
 **/
val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                "BBCharacter"
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().characterDao() }
}
