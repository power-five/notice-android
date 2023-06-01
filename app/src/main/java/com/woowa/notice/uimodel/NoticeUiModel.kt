package com.woowa.notice.uimodel

data class NoticeUIModel(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: WriterUIModel,
    val images: List<ImageUIModel>,
    val createdAt: String,
)
