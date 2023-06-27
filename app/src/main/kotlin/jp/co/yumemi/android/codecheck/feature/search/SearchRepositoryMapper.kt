package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.usecase.search.Repository
import javax.inject.Inject

/**
 * データモデルを変換するためのクラス
 */
class SearchRepositoryMapper @Inject constructor() {
  /**
   * Listをプレゼンテーション用のモデルに変換する
   */
  fun toPresentation(
    repositories: List<Repository>,
  ): List<jp.co.yumemi.android.codecheck.Repository> {
    return repositories.map(::toPresentation)
  }

  private fun toPresentation(
    repository: Repository
  ): jp.co.yumemi.android.codecheck.Repository {
    // 画像は仮です :)
    return jp.co.yumemi.android.codecheck.Repository(
      ownerIconUrl = "https://okuzawats.com/images/profile.webp",
      description = repository.description.orEmpty(),
      forksCount = repository.forkCount,
      stargazersCount = repository.stargazerCount,
    )
  }
}
