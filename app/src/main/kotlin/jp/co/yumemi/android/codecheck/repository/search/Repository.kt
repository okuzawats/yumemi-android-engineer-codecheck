package jp.co.yumemi.android.codecheck.repository.search

/**
 * 検索結果のリポジトリを表す型
 */
data class Repository(
  val description: String? = null,
  val forkCount: Int,
  val stargazerCount: Int,
)
