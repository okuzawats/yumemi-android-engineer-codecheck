package jp.co.yumemi.android.codecheck.feature.detail

import android.content.res.Resources
import jp.co.yumemi.android.codecheck.R
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.ui.ImageLoader
import javax.inject.Inject

/**
 * データモデルの変換を行うためのクラス
 */
class RepositoryDetailMapper @Inject constructor(
  private val resources: Resources,
) {
  /**
   * プレゼンテーション用のデータモデルに変換する
   */
  fun toPresentation(repository: Repository): RepositoryDetailModel {
    return RepositoryDetailModel(
      ownerIconUrl = ImageLoader.ImageUrl(repository.ownerIconUrl),
      description = repository.description,
      forks = resources.getQuantityString(
        R.plurals.repository_fork,
        repository.forksCount,
        repository.forksCount,
      ),
      stars = resources.getQuantityString(
        R.plurals.repository_star,
        repository.stargazersCount,
        repository.stargazersCount,
      ),
    )
  }
}
