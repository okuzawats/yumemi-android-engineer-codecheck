package jp.co.yumemi.android.codecheck.usecase.search

import jp.co.yumemi.android.codecheck.Repository
import kotlinx.coroutines.flow.Flow

/**
 * リポジトリの検索を行うUseCase
 */
interface SearchRepositoryUseCase {
  /**
   * 検索を実行する。
   */
  operator fun invoke(query: String): Flow<List<Repository>>
}
