package com.woowa.notice.repository

import com.woowa.notice.domain.Notice
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.service.RetrofitClient
import com.woowa.notice.util.createResponseCallback

class NoticeDetailRepositoryImpl : NoticeDetailRepository {
    override fun getNotice(
        id: Long,
        onSuccess: (Notice) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService.getNotice(id).enqueue(
            createResponseCallback(onSuccess = {
                onSuccess(it.toDomain())
            }, onFailure),
        )
    }

    override fun deleteNotice(id: Long, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        RetrofitClient.noticeService.deleteNotice(id).enqueue(
            createResponseCallback(
                onSuccess = { onSuccess() },
                onFailure = onFailure,
            ),
        )
    }
}
