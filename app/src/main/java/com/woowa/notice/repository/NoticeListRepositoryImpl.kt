package com.woowa.notice.repository

import com.woowa.notice.domain.NoticeList
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.service.RetrofitClient
import com.woowa.notice.util.createResponseCallback

class NoticeListRepositoryImpl : NoticeListRepository {
    override fun getAllNotices(
        onSuccess: (NoticeList) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService.getNotices().enqueue(
            createResponseCallback(onSuccess = { noticesDTO ->
                onSuccess(noticesDTO.toDomain())
            }, onFailure),
        )
    }
}