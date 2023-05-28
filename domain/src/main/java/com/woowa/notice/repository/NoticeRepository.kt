package com.woowa.notice.repository

import com.woowa.notice.domain.Notice

interface NoticeRepository {
    fun getAll(): List<Notice>
    fun getNotice(): Notice
    fun postNotice(notice: Notice)
}
