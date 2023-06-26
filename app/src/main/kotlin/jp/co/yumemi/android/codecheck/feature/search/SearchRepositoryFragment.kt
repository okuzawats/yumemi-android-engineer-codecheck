/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ListAdapter
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentSearchRepositoryBinding
import jp.co.yumemi.android.codecheck.ui.setOnSearchActionListener
import javax.inject.Inject

/**
 * リポジトリ検索画面のFragment
 */
@AndroidEntryPoint
class SearchRepositoryFragment :
  Fragment(R.layout.fragment_search_repository),
  SearchRepositoryContract.View {

  @Inject
  lateinit var presenter: SearchRepositoryPresenter

  @Inject
  lateinit var adapter: ListAdapter<Repository, SearchRepositoryViewHolder>

  @Inject
  lateinit var dividerItemDecoration: DividerItemDecoration

  private var _binding: FragmentSearchRepositoryBinding? = null

  private val binding: FragmentSearchRepositoryBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentSearchRepositoryBinding.bind(view)

    binding.recyclerView.addItemDecoration(dividerItemDecoration)
    binding.recyclerView.adapter = adapter

    binding.searchInputText.setOnSearchActionListener { editText ->
      presenter.onSearchAction(query = editText.text.toString())
    }
  }

  override fun onDestroyView() {
    binding.recyclerView.adapter = null
    _binding = null
    super.onDestroyView()
  }

  override fun showRepositories(repositories: List<Repository>) {
    adapter.submitList(repositories)
  }
}
