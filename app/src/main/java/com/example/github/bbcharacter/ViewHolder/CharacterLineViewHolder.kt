package com.example.github.bbcharacter.ViewHolder

import android.view.View
import androidx.core.view.ViewCompat
import com.example.github.bbcharacter.databinding.ItemCharacterLineBinding
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.view.ui.detial.DetailActivity
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 *   Created by Lee Zhang on 12/2/20 00:53
 **/
class CharacterLineViewHolder(view : View): BaseViewHolder(view) {

    private lateinit var data: BBCharacter
    private val binding: ItemCharacterLineBinding by bindings(view)

    override fun bindData(data: Any) {
        if (data is BBCharacter) {
            this.data = data
            drawItemUI()
        }
    }

    private fun drawItemUI() {
        binding.apply {
            ViewCompat.setTransitionName(binding.itemContainer, data.name)
            character = data
            executePendingBindings()
        }
    }

    override fun onClick(p0: View?)  =  DetailActivity.startActivity(context(), binding.itemContainer, data)

    override fun onLongClick(p0: View?) = false
}
