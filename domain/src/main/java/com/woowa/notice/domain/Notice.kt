package com.woowa.notice.domain

import java.time.LocalDateTime

data class Notice(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: Writer,
    val images: List<String>,
    val createdAt: LocalDateTime,
)
