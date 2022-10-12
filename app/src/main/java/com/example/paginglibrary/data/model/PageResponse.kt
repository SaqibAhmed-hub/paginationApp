package com.example.paginglibrary.data.model

data class PageResponse(
    val info: pageInfo,
    val results: List<Character>
)


data class pageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)