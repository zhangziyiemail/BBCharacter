package com.example.github.bbcharacter.view.adapter

import android.view.View
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.ViewHolder.CharacterLineViewHolder
import com.example.github.bbcharacter.model.BBCharacter
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 *   Created by Lee Zhang on 12/2/20 00:49
 **/
class CharacterLineAdapter : BaseAdapter() {

    init {
        addSection(arrayListOf<BBCharacter>())
    }

    fun addCharacterList(characters: List<BBCharacter>) {
        sections().first().run {
            clear()
            addAll(characters)
            notifyDataSetChanged()
        }
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_character_line

    override fun viewHolder(layout: Int, view: View) = CharacterLineViewHolder(view)
}
