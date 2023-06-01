package com.woowa.notice.ui.noticelist

import com.woowa.notice.mapper.toUIModel
import com.woowa.notice.repository.NoticeListRepository

class NoticeListPresenter(
    private val view: NoticeListContract.View,
    private val repository: NoticeListRepository,
) : NoticeListContract.Presenter {
    override fun getNoticeList() {
        repository.getAllNotices(
            onSuccess = { notices ->
                view.initRecyclerView(notices.toUIModel())
            },
            onFailure = {
                throw IllegalArgumentException("공지사항 목록을 불러오는데 실패했습니다.")
            }
        )
    }
}
