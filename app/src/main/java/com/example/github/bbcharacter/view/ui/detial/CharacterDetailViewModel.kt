package com.example.github.bbcharacter.view.ui.detial

import com.example.github.bbcharacter.base.LiveCoroutinesViewModel
import com.example.github.bbcharacter.repository.DetailRepository

/**
 *   Created by Lee Zhang on 12/1/20 23:31
 **/
class CharacterDetailViewModel(
    private val repository: DetailRepository
) : LiveCoroutinesViewModel() {
    fun getCharacter(id: String) = repository.getCharacter(id)
}
