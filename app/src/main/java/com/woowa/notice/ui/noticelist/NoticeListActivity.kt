package com.woowa.notice.ui.noticelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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
        setRecyclerViewDivider()
    }

    override fun initRecyclerView(noticeItems: List<NoticeUiModel>) {
        binding.rvNoticeList.adapter = NoticeListAdapter(noticeItems)
    }

    private fun setRecyclerViewDivider() {
        binding.rvNoticeList.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL),
        )
    }
}
