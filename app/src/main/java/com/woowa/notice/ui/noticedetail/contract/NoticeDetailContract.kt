package com.woowa.notice.ui.noticedetail.contract

import com.woowa.notice.uimodel.NoticeUIModel

interface NoticeDetailContract {
    interface View {
        fun setNoticeDetail(notice: NoticeUIModel)
    }

    interface Presenter {
        fun fetchNoticeDetail(id: Long)
        fun deleteNotice(id: Long)
    }
}
