package com.woowa.notice.dto

import com.google.gson.annotations.SerializedName

data class NoticeDTO(
    @SerializedName("noticeId")
    val noticeId: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("writer")
    val writer: WriterDTO,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("createdAt")
    val createdAt: String,
)
