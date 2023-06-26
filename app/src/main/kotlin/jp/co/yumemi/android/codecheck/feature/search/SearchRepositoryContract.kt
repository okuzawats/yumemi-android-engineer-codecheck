package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository

/**
 * リポジトリ検索画面のViewとPresenterが従う契約
 */
interface SearchRepositoryContract {
  /**
   * リポジトリ検索画面のViewを定義するinterface
   */
  interface View

  /**
   * リポジトリ検索画面のPresenterを定義するinterface
   */
  interface Presenter {
    /**
     * リポジトリの検索実行アクションが実行された。
     *
     * @param query 検索語句
     */
    fun onSearchAction(query: String)

    /**
     * リポジトリが選択された.
     *
     * @param repository 選択されたリポジトリ
     */
    fun onRepositorySelected(repository: Repository)
  }
}
