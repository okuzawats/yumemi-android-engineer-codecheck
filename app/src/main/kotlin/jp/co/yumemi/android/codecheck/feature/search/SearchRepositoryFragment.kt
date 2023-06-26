/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentSearchRepositoryBinding
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
  lateinit var dividerItemDecoration: DividerItemDecoration

  @Inject
  lateinit var adapter: SearchRepositoryAdapter

  private var _binding: FragmentSearchRepositoryBinding? = null
  private val binding: FragmentSearchRepositoryBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentSearchRepositoryBinding.bind(view)

    binding.recyclerView.addItemDecoration(dividerItemDecoration)
    binding.recyclerView.adapter = adapter

    binding.searchInputText
      .setOnEditorActionListener { editText, action, _ ->
        if (action == EditorInfo.IME_ACTION_SEARCH) {
          presenter.onSearchAction(query = editText.text.toString())
          return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
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
