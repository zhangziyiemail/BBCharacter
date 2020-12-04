package com.example.github.bbcharacter.repository

import androidx.annotation.WorkerThread
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.network.BBService
import com.example.github.bbcharacter.persistence.CharacterDao
import com.example.github.bbcharacter.utils.LogUtils
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

/**
 *   Created by Lee Zhang on 12/1/20 22:19
 **/
class MainRepository constructor(
    private val bbCharacterServer: BBService,
    private val characterDao: CharacterDao
) : Repository {

    init {
        Timber.d("Injection MainRepository")
    }

    @WorkerThread
    suspend fun loadBBcharacters(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val characters: List<BBCharacter> = characterDao.getCharacterList()
        if (characters.isEmpty()) {
            // request API network call asynchronously.
            bbCharacterServer.fetchCharacterList().apply {
                // handle the case when the API request gets a success response.
                this.suspendOnSuccess {
                    data.whatIfNotNull {
                        characterDao.insertCharacterList(it)
                        emit(it)
                        onSuccess()
                    }
                }
                    // handle the case when the API request gets an error response.
                    // e.g. internal server error.
                    .onError {
                        onError(message())
                    }
                    // handle the case when the API request gets an exception response.
                    // e.g. network connection error.
                    .onException {
                        LogUtils.error("loadBBcharacters" + message())
                        onError(message())

                    }
            }
        } else {
            emit(characters)
            onSuccess()
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
     fun searchCharacter(
        name: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = characterDao.sherachLikeName(name)

    @WorkerThread
    fun searchCharacterWithSeason(
        name: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = characterDao.sheraCharacterSeason(name)

}
