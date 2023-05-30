package com.woowa.notice.ui.noticedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.woowa.notice.databinding.ActivityNoticeDetailBinding
import com.woowa.notice.repository.NoticeDetailRepositoryImpl
import com.woowa.notice.ui.noticedetail.contract.NoticeDetailContract
import com.woowa.notice.ui.noticedetail.contract.presenter.NoticeDetailPresenter
import com.woowa.notice.uimodel.NoticeUIModel

class NoticeDetailActivity : AppCompatActivity(), NoticeDetailContract.View, NoticeDetailListener{
    private lateinit var binding: ActivityNoticeDetailBinding
    private val presenter by lazy { NoticeDetailPresenter(this, NoticeDetailRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.fetchNoticeDetail(intent.getLongExtra(KEY_NOTICE_ID, 0))
    }

    override fun setNoticeDetail(notice: NoticeUIModel) {
        binding.notice = notice
        setNoticeImages(notice.images)
    }

    private fun setNoticeImages(images: List<String>) {
        binding.rvNoticeImg.adapter = NoticeImageAdapter(images)
    }
    override fun onNoticeChangeClick(id: Long) {
        //startActivity(NoticeChangeActivity.newIntent(this, id))
    }

    companion object {
        const val KEY_NOTICE_ID = "notice_id"
        fun newIntent(context: Context, noticeId: Long): Intent {
            return Intent(context, NoticeDetailActivity::class.java).apply {
                putExtra(KEY_NOTICE_ID, noticeId)
            }
        }
    }
}
