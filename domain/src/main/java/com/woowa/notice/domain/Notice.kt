package com.woowa.notice.domain

data class Notice(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: Writer,
    val images: List<Image>,
    val createdAt: String,
)
