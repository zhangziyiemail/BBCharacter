package com.example.github.bbcharacter.model

import androidx.room.TypeConverter
import com.example.github.bbcharacter.utils.LogUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skydoves.whatif.whatIfNotNull

/**
 *   Created by Lee Zhang on 12/2/20 19:29
 **/
class CharacterConverter {

    @TypeConverter
    fun getCharacterFromString(value: String): List<String> {
//        LogUtils.error("value.split(\",\")"+value.split(","))
        return value.split(",")

    }

    @TypeConverter
    fun storeCharacterToString(list: List<String>?): String {
        list.whatIfNotNull {
            if (list!!.size > 0){
                val str = StringBuilder(list[0])
                list.slice(1..list.size-1).forEach(){
                    str.append(",").append(it)
                }
                return str.toString()
            }
        }
        return ""
    }
}


