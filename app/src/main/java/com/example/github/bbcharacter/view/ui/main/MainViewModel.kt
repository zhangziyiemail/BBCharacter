package com.example.github.bbcharacter.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.example.github.bbcharacter.base.LiveCoroutinesViewModel
import com.example.github.bbcharacter.model.BBCharacter
import com.example.github.bbcharacter.repository.MainRepository
import com.example.github.bbcharacter.utils.LogUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 *   Created by Lee Zhang on 12/1/20 22:45
 **/
class MainViewModel constructor(
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

    private var characterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData(true)
    var characterListLiveData: LiveData<List<BBCharacter>>

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    init {
        Timber.d("injection MainViewModel")
        characterListLiveData = characterFetchingLiveData.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.mainRepository.loadBBcharacters(
                    onSuccess = { _isLoading.postValue(false) },
                    onError = { _toastLiveData.postValue(it) }
                ).asLiveData()
            }
        }

    }

    fun searchFetchingLiveData(str: String) =
             mainRepository.searchCharacter(
                str,
                onSuccess = { _isLoading.postValue(false) },
                onError = { _toastLiveData.postValue(it) }
            )

    fun  searchSeasonLiveData(str: String)=
        mainRepository.searchCharacterWithSeason(
            str,
            onSuccess = { _isLoading.postValue(false) },
            onError = { _toastLiveData.postValue(it) }
        )



//        characterListLiveData = characterFetchingLiveData.switchMap {
//            _isLoading.postValue(true)
//            launchOnViewModelScope {
//                this.mainRepository.searchCharacter(
//                    str,
//                    onSuccess = { _isLoading.postValue(false) },
//                    onError = { _toastLiveData.postValue(it) }
//                )
//            }
//        }

}