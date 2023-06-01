package com.woowa.notice.mapper

import com.woowa.notice.domain.Notice
import com.woowa.notice.dto.NoticeDTO
import com.woowa.notice.uimodel.NoticeUIModel

fun Notice.toUIModel(): NoticeUIModel {
    return NoticeUIModel(
        noticeId = this.noticeId,
        title = this.title,
        description = this.description,
        writer = this.writer.toUIModel(),
        images = this.images,
        createdAt = this.createdAt,
    )
}

fun NoticeUIModel.toDomain(): Notice {
    return Notice(
        noticeId = this.noticeId,
        title = this.title,
        description = this.description,
        writer = this.writer.toDomain(),
        images = this.images,
        createdAt = this.createdAt,
    )
}

fun NoticeDTO.toDomain(): Notice {
    return Notice(
        noticeId = this.noticeId,
        title = this.title,
        description = this.description,
        writer = this.writer.toDomain(),
        images = this.images,
        createdAt = this.createdAt,
    )
}
