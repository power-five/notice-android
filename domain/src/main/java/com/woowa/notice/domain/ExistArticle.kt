package com.woowa.notice.domain

data class ExistArticle(
    val title: String,
    val description: String,
    val images: List<Image>
)
