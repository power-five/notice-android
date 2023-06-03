package com.woowa.notice.repository

import com.woowa.notice.domain.Notice
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.service.RetrofitClient
import com.woowa.notice.util.createResponseCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        onSuccess()
                    } else {
                        onFailure(IllegalArgumentException("삭제를 실패했습니다."))
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    onFailure(IllegalArgumentException("삭제를 실패했습니다."))
                }
            },
        )
    }
}
