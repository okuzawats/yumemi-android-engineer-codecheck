package jp.co.yumemi.android.codecheck.feature.search

import androidx.recyclerview.widget.DiffUtil
import jp.co.yumemi.android.codecheck.Repository

/**
 * [DiffUtil]のインスタンスを生成するためのクラス
 */
class SearchRepositoryDiffUtilProvider {
  fun provide(): DiffUtil.ItemCallback<Repository> {
    return object : DiffUtil.ItemCallback<Repository>() {
      override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.name == newItem.name
      }

      override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
      }
    }
  }
}
