package com.woowa.notice.uimodel

data class NoticeListUIModel(
    private val notices: List<NoticeUIModel>,
) {
    val size: Int
        get() = notices.size

    fun getNotice(position: Int): NoticeUIModel {
        return notices[position]
    }
}
