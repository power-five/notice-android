package com.woowa.notice.uimodel

import java.time.LocalDateTime

data class NoticeUiModel(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: WriterUiModel,
    val images: List<String>,
    val createdAt: LocalDateTime,
)
