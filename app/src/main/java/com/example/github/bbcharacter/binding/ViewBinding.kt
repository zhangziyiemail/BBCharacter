package com.example.github.bbcharacter.binding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.github.bbcharacter.extensions.gone

/**
 *   Created by Lee Zhang on 12/2/20 14:13
 **/

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}


@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean?) {
    if (shouldBeGone == true) {
        view.gone(true)
    } else {
        view.gone(false)
    }
}
