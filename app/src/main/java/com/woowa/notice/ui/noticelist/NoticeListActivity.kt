package com.woowa.notice.ui.noticelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.woowa.notice.databinding.ActivityNoticeListBinding
import com.woowa.notice.ui.noticelist.adapter.NoticeListAdapter
import com.woowa.notice.uimodel.NoticeUiModel

class NoticeListActivity : AppCompatActivity(), NoticeListContract.View {
    private val binding: ActivityNoticeListBinding by lazy {
        ActivityNoticeListBinding.inflate(layoutInflater)
    }

    private val presenter: NoticeListContract.Presenter by lazy {
        NoticeListPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.getNoticeList()
    }

    override fun initRecyclerView(noticeItems: List<NoticeUiModel>) {
        binding.rvNoticeList.adapter = NoticeListAdapter(noticeItems)
    }
}
