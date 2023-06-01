package com.woowa.notice.mapper

import com.woowa.notice.domain.Image
import com.woowa.notice.dto.ImageDTO
import com.woowa.notice.uimodel.ImageUIModel

fun Image.toUIModel(): ImageUIModel {
    return ImageUIModel(
        url = this.url,
    )
}

fun ImageUIModel.toDomain(): Image {
    return Image(
        url = this.url,
    )
}

fun ImageDTO.toDomain(): Image {
    return Image(
        url = this.url,
    )
}
