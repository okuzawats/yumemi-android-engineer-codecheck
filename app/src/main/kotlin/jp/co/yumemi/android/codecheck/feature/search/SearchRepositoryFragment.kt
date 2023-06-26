/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentSearchRepositoryBinding
import jp.co.yumemi.android.codecheck.ui.VerticalDividerItemDecoration
import javax.inject.Inject

@AndroidEntryPoint
class SearchRepositoryFragment :
  Fragment(R.layout.fragment_search_repository),
  SearchRepositoryContract.View {

  @Inject
  lateinit var presenter: SearchRepositoryPresenter

  @Inject
  lateinit var verticalDividerItemDecoration: VerticalDividerItemDecoration

  @Inject
  lateinit var searchRepositoryDiffUtilProvider: SearchRepositoryDiffUtilProvider

  private val adapter: SearchRepositoryAdapter by lazy {
    SearchRepositoryAdapter(
      onRepositoryClicked = presenter::onRepositorySelected,
      searchRepositoryDiffUtilProvider = searchRepositoryDiffUtilProvider,
    )
  }

  private var _binding: FragmentSearchRepositoryBinding? = null
  private val binding: FragmentSearchRepositoryBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentSearchRepositoryBinding.bind(view)

    binding.searchInputText
      .setOnEditorActionListener { editText, action, _ ->
        if (action == EditorInfo.IME_ACTION_SEARCH) {
          presenter.onSearchAction(query = editText.text.toString())
          return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
      }

    binding.recyclerView.also {
      it.addItemDecoration(verticalDividerItemDecoration)
      it.adapter = adapter
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
