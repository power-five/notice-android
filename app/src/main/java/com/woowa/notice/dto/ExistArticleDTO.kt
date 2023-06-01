package com.woowa.notice.dto

data class ExistArticleDTO(
    val title: String,
    val description: String,
    val images: List<ImageDTO>
)