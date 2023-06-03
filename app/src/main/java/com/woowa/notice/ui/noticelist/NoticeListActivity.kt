package com.woowa.notice.ui.noticelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.woowa.notice.databinding.ActivityNoticeListBinding
import com.woowa.notice.repository.NoticeListRepositoryImpl
import com.woowa.notice.ui.noticedetail.NoticeDetailActivity
import com.woowa.notice.ui.noticelist.adapter.NoticeListAdapter
import com.woowa.notice.ui.noticewriting.NoticeWritingActivity
import com.woowa.notice.uimodel.NoticeListUIModel

class NoticeListActivity : AppCompatActivity(), NoticeListContract.View {
    private val binding: ActivityNoticeListBinding by lazy {
        ActivityNoticeListBinding.inflate(layoutInflater)
    }

    private val presenter: NoticeListContract.Presenter by lazy {
        NoticeListPresenter(this, NoticeListRepositoryImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNoticeList()
        setAddNoticeButtonListener()
    }

    override fun onStart() {
        super.onStart()
        updateNoticeList()
    }

    override fun setNoticeList(notices: NoticeListUIModel) {
        (binding.rvNoticeList.adapter as NoticeListAdapter).updateNoticeList(notices)
    }

    private fun initNoticeList() {
        binding.rvNoticeList.adapter = NoticeListAdapter(NoticeListUIModel(emptyList())) { id ->
            showNoticeDetail(id)
        }
        setListAnimator()
        setRecyclerViewDivider()
    }

    private fun updateNoticeList() {
        presenter.getNoticeList()
    }

    private fun setAddNoticeButtonListener() {
        binding.btnAddNotice.setOnClickListener {
            startActivity(NoticeWritingActivity.newIntent(this, -1))
        }
    }

    private fun setRecyclerViewDivider() {
        binding.rvNoticeList.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL),
        )
    }

    private fun setListAnimator() {
        val animator = binding.rvNoticeList.itemAnimator
        if (animator is SimpleItemAnimator) {
            animator.supportsChangeAnimations = false
        }
    }

    private fun showNoticeDetail(id: Long) {
        val intent = NoticeDetailActivity.newIntent(this, id)
        startActivity(intent)
    }
}
