package com.woowa.notice.dto

data class ArticleDTO(
    val title: String,
    val description: String,
    val writerId: Int,
    val images: List<ImageDTO>,
)
