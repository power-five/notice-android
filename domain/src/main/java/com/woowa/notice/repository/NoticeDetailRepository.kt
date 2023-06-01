package com.woowa.notice.repository

import com.woowa.notice.domain.Notice

interface NoticeDetailRepository {
    fun getNotice(id: Long, onSuccess: (Notice) -> Unit, onFailure: (Exception) -> Unit)
    fun deleteNotice(id: Long, onSuccess: () -> Unit, onFailure: (Exception) -> Unit)
}
