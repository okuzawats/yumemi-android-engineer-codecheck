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
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.FragmentSearchRepositoryBinding

@AndroidEntryPoint
class SearchRepositoryFragment : Fragment(R.layout.fragment_search_repository) {

  private val viewModel: SearchRepositoryViewModel by viewModels()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val _binding = FragmentSearchRepositoryBinding.bind(view)

    val _layoutManager = LinearLayoutManager(context!!)
    val _dividerItemDecoration =
      DividerItemDecoration(context!!, _layoutManager.orientation)
    val _adapter =
      SearchRepositoryAdapter(object : SearchRepositoryAdapter.OnItemClickListener {
        override fun itemClick(repository: Repository) {
          gotoRepositoryFragment(repository = repository)
        }
      })

    _binding.searchInputText
      .setOnEditorActionListener { editText, action, _ ->
        if (action == EditorInfo.IME_ACTION_SEARCH) {
          editText.text.toString().let {
            viewModel.searchResults(it).apply {
              _adapter.submitList(this)
            }
          }
          return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
      }

    _binding.recyclerView.also {
      it.layoutManager = _layoutManager
      it.addItemDecoration(_dividerItemDecoration)
      it.adapter = _adapter
    }
  }

  fun gotoRepositoryFragment(repository: Repository) {
    val _action =
      SearchRepositoryFragmentDirections.toRepositoryDetail(repository = repository)
    findNavController().navigate(_action)
  }
}

val diffUtil: DiffUtil.ItemCallback<Repository> = object : DiffUtil.ItemCallback<Repository>() {
  override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
    return oldItem.name == newItem.name
  }

  override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
    return oldItem == newItem
  }
}
