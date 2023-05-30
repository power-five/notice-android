package com.woowa.notice.ui.noticelist

import com.woowa.notice.uimodel.NoticeUiModel
import com.woowa.notice.uimodel.WriterUiModel
import java.time.LocalDateTime

class NoticeListPresenter(
    private val view: NoticeListContract.View,
) : NoticeListContract.Presenter {
    override fun getNoticeList() {
        val noticeItems = List(30) { it ->
            val index = it + 1
            NoticeUiModel(
                noticeId = index.toLong(),
                title = "$index: 여러분 ~ 안녕하세요 ~",
                description = "근로 근로 ~~~",
                writer = WriterUiModel(
                    nickname = "하티",
                    image = "https://mblogthumb-phinf.pstatic.net/MjAyMDA4MThfMTky/MDAxNTk3NjgyMTM4NTcy.5HceBl98We4er9BqSFRETcdKc4SU7gc-XMWxg_vLIT4g.TmmA3JVnDPtrqm9yOlg3SzseeRiYBHgBkYJU-gMZSXog.JPEG.clcl4423/1597682137730.jpg?type=w800",
                ),
                images = listOf(
                    "https://file2.nocutnews.co.kr/newsroom/image/2015/08/21/20150821223000718087.jpg",
                ),
                createdAt = LocalDateTime.of(2023, 5, 30, 21, 33),
            )
        }

        view.initRecyclerView(noticeItems)
    }
}
