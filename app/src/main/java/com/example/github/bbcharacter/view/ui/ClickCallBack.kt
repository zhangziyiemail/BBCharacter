package com.example.github.bbcharacter.view.ui

import android.text.TextUtils
import androidx.room.util.StringUtil
import com.example.github.bbcharacter.model.BBCharacter

/**
 *   Created by Lee Zhang on 12/3/20 01:02
 **/
var listener: ((BBCharacter)->Unit)? = null

fun strfromList(list : List<String>): String{
    return TextUtils.join(",",list)
}