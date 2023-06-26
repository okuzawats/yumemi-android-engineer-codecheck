package jp.co.yumemi.android.codecheck.feature.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.LayoutRepositoryBinding

/**
 * リポジトリ検索画面のリスト表示のためのAdapter
 *
 * @param onRepositoryClicked リポジトリタップ時に発火するラムダ
 * @param searchRepositoryDiffUtilProvider DiffUtil
 */
class SearchRepositoryAdapter(
  private val onRepositoryClicked: (Repository) -> Unit,
  searchRepositoryDiffUtilProvider: SearchRepositoryDiffUtilProvider,
) : ListAdapter<Repository, SearchRepositoryViewHolder>(
  searchRepositoryDiffUtilProvider.provide(),
) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int,
  ): SearchRepositoryViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(
      R.layout.layout_repository, parent, false
    )
    val binding = LayoutRepositoryBinding.bind(view)
    return SearchRepositoryViewHolder(binding = binding)
  }

  override fun onBindViewHolder(
    holder: SearchRepositoryViewHolder,
    position: Int,
  ) {
    val repository = getItem(position)
    holder.binding.repositoryNameView.text = repository.name
    holder.binding.root.setOnClickListener {
      onRepositoryClicked(repository)
    }
  }
}
