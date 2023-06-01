package com.woowa.notice.dto

import com.google.gson.annotations.SerializedName

data class ImageDTO(
    @SerializedName("imageUrl")
    val url: String,
)
