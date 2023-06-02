package com.woowa.notice.domain

data class Article(
    val title: String,
    val description: String,
    val writer: Writer,
    val images: List<Image>
)
