package com.example.paginglibrary.data.service

import com.example.paginglibrary.data.model.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getCharacter(
        @Query("page") page: Int
    ): Response<PageResponse>


}