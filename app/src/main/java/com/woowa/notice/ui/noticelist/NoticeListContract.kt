package com.woowa.notice.ui.noticelist

import com.woowa.notice.uimodel.NoticeListUIModel

interface NoticeListContract {
    interface View {
        fun initRecyclerView(notices: NoticeListUIModel)
    }

    interface Presenter {
        fun getNoticeList()
    }
}
