package com.woowa.notice.ui.noticewriting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.woowa.notice.databinding.ActivityNoticeWritingBinding
import com.woowa.notice.repository.NoticeDetailRepositoryImpl
import com.woowa.notice.repository.NoticeWritingRepositoryImpl
import com.woowa.notice.uimodel.ExistArticleUIModel
import com.woowa.notice.uimodel.ImageUIModel

class NoticeWritingActivity : AppCompatActivity(), NoticeWritingContract.View {
    private lateinit var binding: ActivityNoticeWritingBinding
    private lateinit var presenter: NoticeWritingPresenter
    private lateinit var adapter: NoticeWritingAdapter
    private var noticeId: Long = -1

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            val inputStream = contentResolver.openInputStream(uri!!)
            inputStream?.close()
            presenter.addPhoto(uri.toString())
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()
        initAdapter()
        initView()
        initButtonListener()
    }

    private fun initPresenter() {
        presenter = NoticeWritingPresenter(
            view = this,
            noticeDetailRepository = NoticeDetailRepositoryImpl(),
            noticeWritingRepository = NoticeWritingRepositoryImpl()
        )
    }

    private fun initAdapter() {
        adapter = NoticeWritingAdapter(
            images = emptyList(),
            noticeWritingClickListener = object : NoticeWritingClickListener {
                override fun onClickRemove(imageUIModel: ImageUIModel) {
                    presenter.removePhoto(imageUIModel)
                }
            }
        )
        binding.rvImagePreviews.adapter = adapter
    }

    private fun initView() {
        noticeId = intent.getLongExtra(KEY_NOTICE_ID, -1)
        if (noticeId >= 0) {
            runOnUiThread {
                presenter.loadPost(noticeId)
            }
        }
    }

    private fun initButtonListener() {
        binding.tvPostButton.setOnClickListener {
            presenter.submitPost(
                noticeId,
                binding.etTitle.text.toString(),
                binding.etDescription.text.toString()
            )
            finish()
        }
        binding.ivCancelButton.setOnClickListener {
            finish()
        }
        binding.ivImageAddButton.setOnClickListener {
            galleryLauncher.launch("image/*")
        }
    }

    override fun setViewContents(article: ExistArticleUIModel) {
        adapter.update(article.images)
        binding.etTitle.setText(article.title)
        binding.etDescription.setText(article.description)
    }

    override fun updateImageView(images: List<ImageUIModel>) {
        adapter.update(images)
    }

    override fun showImpossibleToAddImageToast() {
        Toast.makeText(this, "사진은 최대 10장까지 첨부 가능합니다.", LENGTH_SHORT).show()
    }

    companion object {
        const val KEY_NOTICE_ID = "notice_id"
        fun newIntent(context: Context, noticeId: Long): Intent {
            return Intent(context, NoticeWritingActivity::class.java).apply {
                putExtra(KEY_NOTICE_ID, noticeId)
            }
        }
    }
}