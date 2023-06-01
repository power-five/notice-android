package com.woowa.notice.ui.noticelist

import com.woowa.notice.uimodel.ImageUIModel
import com.woowa.notice.uimodel.NoticeUIModel
import com.woowa.notice.uimodel.WriterUIModel
import java.time.LocalDateTime

class NoticeListPresenter(
    private val view: NoticeListContract.View,
) : NoticeListContract.Presenter {
    override fun getNoticeList() {
        val noticeItems = List(30) { it ->
            val index = it + 1
            NoticeUIModel(
                noticeId = index.toLong(),
                title = "$index: 여러분 ~ 안녕하세요 ~",
                description = "근로 근로 ~~~",
                writer = WriterUIModel(
                    nickname = "하티",
                    image = "https://mblogthumb-phinf.pstatic.net/MjAyMDA4MThfMTky/MDAxNTk3NjgyMTM4NTcy.5HceBl98We4er9BqSFRETcdKc4SU7gc-XMWxg_vLIT4g.TmmA3JVnDPtrqm9yOlg3SzseeRiYBHgBkYJU-gMZSXog.JPEG.clcl4423/1597682137730.jpg?type=w800",
                ),
                images = listOf(
                    ImageUIModel("https://file2.nocutnews.co.kr/newsroom/image/2015/08/21/20150821223000718087.jpg"),
                ),
                createdAt = LocalDateTime.of(2023, 5, 30, 21, 33).toString(),
            )
        }

        view.initRecyclerView(noticeItems)
    }
}
