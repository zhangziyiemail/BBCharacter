package com.example.github.bbcharacter.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.github.bbcharacter.model.BBCharacter

/**
 *   Created by Lee Zhang on 12/1/20 22:13
 **/
@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(characters: List<BBCharacter>)

    @Query("SELECT * FROM BBCharacter WHERE char_id= :id_")
    fun getCharacter(id_: String): BBCharacter

    @Query("SELECT * FROM BBCharacter")
    suspend fun getCharacterList(): List<BBCharacter>

    @Query("SELECT * FROM BBCharacter WHERE name LIKE '%' || :name || '%'")
     fun sherachLikeName(name : String):  List<BBCharacter>

    @Query("SELECT * FROM BBCharacter WHERE appearance LIKE '%' || :season || '%'")
    fun sheraCharacterSeason(season : String):  List<BBCharacter>
}