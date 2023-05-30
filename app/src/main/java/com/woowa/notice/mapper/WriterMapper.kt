package com.woowa.notice.mapper

import com.woowa.notice.domain.Writer
import com.woowa.notice.uimodel.WriterUIModel

fun Writer.toUIModel(): WriterUIModel {
    return WriterUIModel(
        nickname = this.nickname,
        image = this.image,
    )
}

fun WriterUIModel.toDomain(): Writer {
    return Writer(
        nickname = this.nickname,
        image = this.image,
    )
}
