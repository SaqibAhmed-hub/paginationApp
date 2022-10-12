package com.example.paginglibrary.data.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginglibrary.data.model.Character
import com.example.paginglibrary.data.service.ApiService

class PagingDataSource(private val apiService: ApiService) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1
        return try {
            val response = apiService.getCharacter(pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.results
            var nextPageNumber: Int? = null
            if (pagedResponse?.info?.pages != null) {
                val uri = Uri.parse(pagedResponse.info.next)
                val nextQueryPage = uri.getQueryParameter("page")
                nextPageNumber = nextQueryPage?.toInt()
            }
            LoadResult.Page(
                data = data!!,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}