package com.woowa.notice.repository

import com.woowa.notice.domain.NoticeList

interface NoticeListRepository {
    fun getAllNotices(onSuccess: (NoticeList) -> Unit, onFailure: (Exception) -> Unit)
}