package com.example.github.bbcharacter.binding

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.view.adapter.CharacterLineAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

/**
 *   Created by Lee Zhang on 12/2/20 14:17
 **/
@BindingAdapter("adapterPosterLineList")
fun bindAdapterPosterLineList(view: RecyclerView, characters: List<BBCharacter>?) {
    characters.whatIfNotNullOrEmpty {
        (view.adapter as? CharacterLineAdapter)?.addCharacterList(it)
    }
}

@BindingAdapter("toast")
fun bindToast(view: RecyclerView, text: String?) {
    text.whatIfNotNullOrEmpty {
        Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
    }
}
