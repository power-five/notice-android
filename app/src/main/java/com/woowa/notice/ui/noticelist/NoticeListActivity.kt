package com.woowa.notice.ui.noticelist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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

    override fun initRecyclerView(notices: NoticeListUIModel) {
        binding.rvNoticeList.adapter = NoticeListAdapter(notices) { id ->
            showNoticeDetail(id)
        }
    }

    private fun initNoticeList() {
        presenter.getNoticeList()
        setRecyclerViewDivider()
    }

    private fun setAddNoticeButtonListener() {
        binding.btnAddNotice.setOnClickListener {
            startActivity(NoticeWritingActivity.newIntent(this, -1))
            Toast.makeText(this, "공지사항 추가 화면으로 이동", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerViewDivider() {
        binding.rvNoticeList.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL),
        )
    }

    private fun showNoticeDetail(id: Long) {
        val intent = NoticeDetailActivity.newIntent(this, id)
        startActivity(intent)
    }
}
