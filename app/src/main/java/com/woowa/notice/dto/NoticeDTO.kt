package com.woowa.notice.dto

data class NoticeDTO(
    val noticeId: Long,
    val title: String,
    val description: String,
    val writer: WriterDTO,
    val images: List<ImageDTO>,
    val createdAt: String,
)
