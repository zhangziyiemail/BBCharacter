package com.example.github.bbcharacter.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.model.CharacterConverter

/**
 *   Created by Lee Zhang on 12/1/20 22:12
 **/
@Database(entities = [BBCharacter::class], version = 1, exportSchema = true)
@TypeConverters(CharacterConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun  characterDao(): CharacterDao
}
