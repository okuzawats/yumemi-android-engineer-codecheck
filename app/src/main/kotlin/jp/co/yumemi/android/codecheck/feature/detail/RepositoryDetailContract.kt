package jp.co.yumemi.android.codecheck.feature.detail

/**
 * リポジトリ詳細画面の契約
 */
interface RepositoryDetailContract {
  /**
   * リポジトリ詳細画面のViewを定義するinterface
   */
  interface View {
    /**
     * リポジトリの詳細を表示する
     */
    fun showRepository(repository: RepositoryDetailModel)
  }

  /**
   * リポジトリ詳細画面のPresenterを定義するinterface
   */
  interface Presenter {
    /**
     * 表示された
     */
    fun onEntered()
  }
}
