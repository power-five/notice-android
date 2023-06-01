package com.woowa.notice.uimodel

data class ArticleUIModel(
    val title: String,
    val description: String,
    val writer: WriterUIModel,
    val images: List<ImageUIModel>
)