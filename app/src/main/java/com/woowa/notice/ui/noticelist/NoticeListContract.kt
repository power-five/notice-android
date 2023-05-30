package com.woowa.notice.ui.noticelist

import com.woowa.notice.uimodel.NoticeUiModel

interface NoticeListContract {
    interface View {
        fun initRecyclerView(noticeItems: List<NoticeUiModel>)
    }

    interface Presenter {
        fun getNoticeList()
    }
}
