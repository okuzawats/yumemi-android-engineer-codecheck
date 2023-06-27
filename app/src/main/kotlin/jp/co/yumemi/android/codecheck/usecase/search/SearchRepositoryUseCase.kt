package jp.co.yumemi.android.codecheck.usecase.search

import kotlinx.coroutines.flow.Flow

/**
 * リポジトリの検索を行うUseCase
 */
interface SearchRepositoryUseCase {
  /**
   * 検索を実行する。
   */
  suspend operator fun invoke(query: String): Flow<List<Repository>>
}
