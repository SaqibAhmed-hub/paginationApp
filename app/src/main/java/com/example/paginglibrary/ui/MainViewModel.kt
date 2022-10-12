package com.example.paginglibrary.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginglibrary.data.model.Character
import com.example.paginglibrary.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
    ) : ViewModel() {

    fun getAllCharacters(): Flow<PagingData<Character>>{
            return characterRepository.fetchData().cachedIn(viewModelScope)
    }
}