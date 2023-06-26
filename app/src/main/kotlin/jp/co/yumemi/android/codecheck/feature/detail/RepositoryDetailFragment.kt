/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentRepositoryDetailBinding
import jp.co.yumemi.android.codecheck.ui.ImageLoader
import javax.inject.Inject

@AndroidEntryPoint
class RepositoryDetailFragment :
  Fragment(R.layout.fragment_repository_detail),
  RepositoryDetailContract.View {

  @Inject
  lateinit var presenter: RepositoryDetailPresenter

  @Inject
  lateinit var imageLoader: ImageLoader

  private var _binding: FragmentRepositoryDetailBinding? = null
  private val binding: FragmentRepositoryDetailBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentRepositoryDetailBinding.bind(view)
    presenter.onEntered()
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  override fun showRepository(repository: Repository) {
    imageLoader
      .load(ImageLoader.ImageUrl(repository.ownerIconUrl))
      .into(binding.ownerIconView)
    binding.nameView.text = repository.name
    binding.languageView.text = getString(R.string.written_language, repository.language)
    binding.starsView.text = resources.getQuantityString(
      R.plurals.repository_star,
      repository.stargazersCount.toInt(),
      repository.stargazersCount.toInt(),
    )
    binding.watchersView.text = resources.getQuantityString(
      R.plurals.repository_watcher,
      repository.watchersCount.toInt(),
      repository.watchersCount.toInt(),
    )
    binding.forksView.text = resources.getQuantityString(
      R.plurals.repository_fork,
      repository.forksCount.toInt(),
      repository.forksCount.toInt(),
    )
    binding.openIssuesView.text = resources.getQuantityString(
      R.plurals.repository_open_issue,
      repository.openIssuesCount.toInt(),
      repository.openIssuesCount.toInt(),
    )
  }
}
