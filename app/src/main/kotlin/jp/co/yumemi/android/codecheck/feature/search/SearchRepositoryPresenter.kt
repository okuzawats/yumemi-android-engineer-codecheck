package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository
import javax.inject.Inject

/**
 * [SearchRepositoryContract.Presenter]の実装クラス
 */
class SearchRepositoryPresenter @Inject constructor() :
  SearchRepositoryContract.Presenter {
  override fun onRepositorySelected(
    repository: Repository,
  ) {
    // TODO
  }
}
