package jp.co.yumemi.android.codecheck.feature.detail

import jp.co.yumemi.android.codecheck.ui.ImageLoader

/**
 * リポジトリ詳細を表すデータモデル
 */
data class RepositoryDetailModel(
  val ownerIconUrl: ImageLoader.ImageUrl,
  val description: String,
  val forks: String,
  val stars: String,
)
