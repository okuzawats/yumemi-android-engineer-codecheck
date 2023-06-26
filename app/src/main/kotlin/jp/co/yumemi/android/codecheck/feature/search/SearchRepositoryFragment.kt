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
import javax.inject.Inject

@AndroidEntryPoint
class SearchRepositoryFragment :
  Fragment(R.layout.fragment_search_repository),
  SearchRepositoryContract.View {

  @Inject
  lateinit var presenter: SearchRepositoryPresenter

  private val viewModel: SearchRepositoryViewModel by viewModels()

  private val adapter: SearchRepositoryAdapter by lazy {
    SearchRepositoryAdapter(
      onRepositoryClicked = {
        presenter.onRepositorySelected(repository = it)
      },
      searchRepositoryDiffUtilProvider = SearchRepositoryDiffUtilProvider(),
    )
  }

  private var _binding: FragmentSearchRepositoryBinding? = null
  private val binding: FragmentSearchRepositoryBinding
    get() = checkNotNull(_binding)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    _binding = FragmentSearchRepositoryBinding.bind(view)

    val orientation =
      (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
    val dividerItemDecoration =
      DividerItemDecoration(requireContext(), orientation)

    binding.searchInputText
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

    binding.recyclerView.also {
      it.addItemDecoration(dividerItemDecoration)
      it.adapter = adapter
    }
  }

  override fun onDestroyView() {
    binding.recyclerView.adapter = null
    _binding = null
    super.onDestroyView()
  }

  fun gotoRepositoryFragment(repository: Repository) {
    val _action =
      SearchRepositoryFragmentDirections.toRepositoryDetail(repository = repository)
    findNavController().navigate(_action)
  }
}
