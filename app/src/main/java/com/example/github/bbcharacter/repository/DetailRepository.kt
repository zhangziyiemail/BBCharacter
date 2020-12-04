package com.example.github.bbcharacter.repository

import com.example.github.bbcharacter.persistence.CharacterDao

/**
 *   Created by Lee Zhang on 12/1/20 22:37
 **/
class DetailRepository constructor(
    private val characterDao: CharacterDao
) : Repository {
    fun getCharacter(id: String) = characterDao.getCharacter(id)
}