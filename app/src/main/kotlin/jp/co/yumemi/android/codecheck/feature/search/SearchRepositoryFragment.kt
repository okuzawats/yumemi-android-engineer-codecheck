/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentSearchRepositoryBinding

@AndroidEntryPoint
class SearchRepositoryFragment : Fragment(R.layout.fragment_search_repository) {

  private val viewModel: SearchRepositoryViewModel by viewModels()

  private val adapter: SearchRepositoryAdapter by lazy {
    SearchRepositoryAdapter(
      onRepositoryClicked = {
        gotoRepositoryFragment(repository = it)
      },
      searchRepositoryDiffUtilProvider = SearchRepositoryDiffUtilProvider(),
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val _binding = FragmentSearchRepositoryBinding.bind(view)

    val orientation = (_binding.recyclerView.layoutManager as LinearLayoutManager).orientation
    val dividerItemDecoration = DividerItemDecoration(requireContext(), orientation)

    _binding.searchInputText
      .setOnEditorActionListener { editText, action, _ ->
        if (action == EditorInfo.IME_ACTION_SEARCH) {
          editText.text.toString().let {
            viewModel.searchResults(it).apply {
              adapter.submitList(this)
            }
          }
          return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
      }

    _binding.recyclerView.also {
      it.addItemDecoration(dividerItemDecoration)
      it.adapter = adapter
    }
  }

  fun gotoRepositoryFragment(repository: Repository) {
    val _action =
      SearchRepositoryFragmentDirections.toRepositoryDetail(repository = repository)
    findNavController().navigate(_action)
  }
}
