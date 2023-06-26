package jp.co.yumemi.android.codecheck.feature.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.databinding.LayoutRepositoryBinding
import javax.inject.Inject

/**
 * リポジトリ検索画面のリスト表示のためのAdapter
 *
 * @param presenter Presenter
 * @param searchRepositoryDiffUtilProvider DiffUtil
 */
class SearchRepositoryAdapter(
  private val presenter: SearchRepositoryContract.Presenter,
  diffUtil: DiffUtil.ItemCallback<Repository>,
) : ListAdapter<Repository, SearchRepositoryViewHolder>(diffUtil) {
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
      presenter.onRepositorySelected(repository = repository)
    }
  }
}
