package com.example.paginglibrary.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paginglibrary.data.model.Character
import com.example.paginglibrary.data.paging.PagingDataSource
import com.example.paginglibrary.data.service.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(private val apiService: ApiService) {

    fun fetchData(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 200, initialLoadSize = 10),
        pagingSourceFactory = { PagingDataSource(apiService) }
    ).flow

}