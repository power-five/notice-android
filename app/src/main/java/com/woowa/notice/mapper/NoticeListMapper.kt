package com.woowa.notice.mapper

import com.woowa.notice.domain.NoticeList
import com.woowa.notice.dto.NoticeListDTO
import com.woowa.notice.uimodel.NoticeListUIModel

fun NoticeList.toUIModel(): NoticeListUIModel {
    return NoticeListUIModel(
        notices = this.notices.map { it.toUIModel() },
    )
}

fun NoticeListDTO.toDomain(): NoticeList {
    return NoticeList(
        notices = this.notices.map { it.toDomain() },
    )
}
