package com.example.github.bbcharacter.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

/**
 *   Created by Lee Zhang on 12/1/20 21:57
 **/

@Entity
@Parcelize
@TypeConverters(CharacterConverter::class)
data class BBCharacter(
    @PrimaryKey val char_id: String,
    val name: String,
    val birthday: String,
    val img: String,
    val occupation: List<String>,
    val status: String,
    val nickname: String,
    val appearance: List<String>,
    val portrayed: String,
    val category: String,
    val better_call_saul_appearance: List<String>
) : Parcelable

