package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository

/**
 * リポジトリ検索画面のナビゲーションを行うためのinterface
 */
interface SearchRepositoryNavigator {
  /**
   * リポジトリ詳細の表示
   */
  fun toRepositoryDetail(repository: Repository)
}
