/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentRepositoryDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class RepositoryDetailFragment :
  Fragment(R.layout.fragment_repository_detail),
  RepositoryDetailContract.View {

  @Inject
  lateinit var presenter: RepositoryDetailPresenter

  private var _binding: FragmentRepositoryDetailBinding? = null
  private val binding: FragmentRepositoryDetailBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentRepositoryDetailBinding.bind(view)
    presenter.onEntered()
  }

  override fun showRepository(repository: Repository) {
    binding.ownerIconView.load(repository.ownerIconUrl)
    binding.nameView.text = repository.name
    binding.languageView.text = repository.language
    binding.starsView.text = "${repository.stargazersCount} stars"
    binding.watchersView.text = "${repository.watchersCount} watchers"
    binding.forksView.text = "${repository.forksCount} forks"
    binding.openIssuesView.text = "${repository.openIssuesCount} open issues"
  }
}
