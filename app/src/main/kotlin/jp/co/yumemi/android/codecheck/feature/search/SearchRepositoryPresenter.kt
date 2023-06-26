package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository
import javax.inject.Inject

/**
 * [SearchRepositoryContract.Presenter]の実装クラス
 */
class SearchRepositoryPresenter @Inject constructor(
  private val navigator: SearchRepositoryNavigator,
) : SearchRepositoryContract.Presenter {
  override fun onSearchAction(query: String) {
    TODO("Not yet implemented")
  }

  override fun onRepositorySelected(
    repository: Repository,
  ) {
    navigator.toRepositoryDetail(repository = repository)
  }
}
