package com.woowa.notice.repository

import com.woowa.notice.domain.Notice
import com.woowa.notice.mapper.toDomain
import com.woowa.notice.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback

class NoticeDetailRepositoryImpl : NoticeDetailRepository {
    override fun getNotice(
        id: Long,
        onSuccess: (Notice) -> Unit,
        onFailure: (Exception) -> Unit,
    ) {
        RetrofitClient.noticeService.getNotice(1).enqueue(
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

    private inline fun <reified T> createResponseCallback(
        crossinline onSuccess: (T) -> Unit,
        crossinline onFailure: (Exception) -> Unit,
    ): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    onSuccess(responseBody)
                } else {
                    onFailure(Exception("Response unsuccessful"))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFailure(Exception("Response unsuccessful"))
            }
        }
    }
}
