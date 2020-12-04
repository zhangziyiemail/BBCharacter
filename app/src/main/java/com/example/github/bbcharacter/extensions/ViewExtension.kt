package com.example.github.bbcharacter.extensions

import android.view.View

/**
 *   Created by Lee Zhang on 12/2/20 14:15
 **/

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone(shouldBeGone: Boolean) {
    if (shouldBeGone) visibility = View.GONE
    else visible()
}
