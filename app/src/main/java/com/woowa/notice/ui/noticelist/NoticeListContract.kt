package com.woowa.notice.ui.noticelist

import com.woowa.notice.uimodel.NoticeUIModel

interface NoticeListContract {
    interface View {
        fun initRecyclerView(noticeItems: List<NoticeUIModel>)
    }

    interface Presenter {
        fun getNoticeList()
    }
}
