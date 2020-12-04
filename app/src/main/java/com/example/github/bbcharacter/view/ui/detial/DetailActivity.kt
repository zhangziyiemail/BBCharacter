package com.example.github.bbcharacter.view.ui.detial

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.github.bbcharacter.R
import com.example.github.bbcharacter.base.DatabindingActivity
import com.example.github.bbcharacter.databinding.ActivityCharacterDetailBinding
import com.example.github.bbcharacter.extensions.applyMaterialTransform
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.utils.LogUtils
import com.skydoves.bundler.bundle
import com.skydoves.bundler.intentOf
import org.koin.android.viewmodel.ext.android.getViewModel

/**
 *   Created by Lee Zhang on 12/3/20 01:27
 **/
class DetailActivity : DatabindingActivity() {

    private val binding: ActivityCharacterDetailBinding by binding(R.layout.activity_character_detail)
    private val characterId: String by bundle(EXTRA_CHARACTER_ID, "1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val character = getViewModel<CharacterDetailViewModel>().getCharacter(characterId)
        applyMaterialTransform(character.name)
        binding.apply {
            this.character = character
            lifecycleOwner = this@DetailActivity
            activity = this@DetailActivity
            container = detailContainer

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID"

        fun startActivity(context: Context?, startView: View, character: BBCharacter) {
            if (context is Activity) {
                context.intentOf<DetailActivity> {
                    putExtra(EXTRA_CHARACTER_ID, character.char_id)
                    val options = ActivityOptions.makeSceneTransitionAnimation(
                        context,
                        startView,
                        character.name
                    )
                    startActivity(context, options.toBundle())
                }
            }
        }
    }
}
