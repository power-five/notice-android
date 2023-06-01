package com.woowa.notice.ui.noticewriting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.woowa.notice.databinding.ActivityNoticeWritingBinding
import com.woowa.notice.repository.NoticeDetailRepositoryImpl
import com.woowa.notice.repository.NoticeWritingRepositoryImpl
import com.woowa.notice.uimodel.NoticeUIModel

class NoticeWritingActivity : AppCompatActivity(), NoticeWritingContract.View {
    private lateinit var binding: ActivityNoticeWritingBinding
    private lateinit var presenter: NoticeWritingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initView()
    }

    private fun initPresenter() {
        presenter = NoticeWritingPresenter(
            view = this,
            noticeDetailRepository = NoticeDetailRepositoryImpl(),
            noticeWritingRepository = NoticeWritingRepositoryImpl()
        )
    }

    private fun initView() {
        presenter.loadPost(1)
    }

    override fun setViewContents(notice: NoticeUIModel) {
        binding.notice = notice
    }
}