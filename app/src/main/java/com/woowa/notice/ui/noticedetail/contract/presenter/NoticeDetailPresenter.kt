package com.woowa.notice.ui.noticedetail.contract.presenter

import com.woowa.notice.mapper.toUIModel
import com.woowa.notice.repository.NoticeDetailRepository
import com.woowa.notice.ui.noticedetail.contract.NoticeDetailContract

class NoticeDetailPresenter(
    private val view: NoticeDetailContract.View,
    private val repository: NoticeDetailRepository,
) : NoticeDetailContract.Presenter {

    override fun fetchNoticeDetail(id: Long) {
        repository.getNotice(
            id,
            onSuccess = { view.setNoticeDetail(it.toUIModel()) },
            onFailure = { throw IllegalArgumentException("상세보기를 실패했습니다.") },
        )
    }

    override fun deleteNotice(id: Long) {
        repository.deleteNotice(
            id,
            onSuccess = { },
            onFailure = { throw IllegalArgumentException("삭제를 실패했습니다.") },
        )
    }
}
