package jp.co.yumemi.android.codecheck.feature.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository

/**
 * リポジトリ検索画面のリスト表示のためのAdapter
 */
class SearchRepositoryAdapter(
  private val itemClickListener: OnItemClickListener
) : ListAdapter<Repository, ViewHolder>(diff_util) {

  interface OnItemClickListener {
    fun itemClick(repository: Repository)
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val _view = LayoutInflater.from(parent.context)
      .inflate(R.layout.layout_item, parent, false)
    return SearchRepositoryViewHolder(_view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val _item = getItem(position)
    (holder.itemView.findViewById<View>(R.id.repositoryNameView) as TextView).text =
      _item.name

    holder.itemView.setOnClickListener {
      itemClickListener.itemClick(_item)
    }
  }
}
