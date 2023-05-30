package com.woowa.notice.repository

import com.woowa.notice.domain.Notice

class NoticeDetailRepositoryImpl : NoticeDetailRepository {
    override fun getNotice(
        id: Long,
        onSuccess: (Notice) -> Unit,
        onFailure: (Exception) -> Unit,
    ): Notice {
        TODO("Not yet implemented")
    }
}
