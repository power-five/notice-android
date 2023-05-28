package com.woowa.notice.dto

import com.google.gson.annotations.SerializedName

data class WriterDTO(
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("image")
    val image: String,
)
