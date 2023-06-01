package com.woowa.notice.uimodel

import java.time.LocalDateTime

data class NoticeUIModel(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: WriterUIModel,
    val images: List<String>,
    val createdAt: LocalDateTime,
)
