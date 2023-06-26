package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.usecase.search.SearchRepositoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * [SearchRepositoryContract.Presenter]の実装クラス
 */
class SearchRepositoryPresenter @Inject constructor(
  private val view: SearchRepositoryContract.View,
  private val searchRepositoryUseCase: SearchRepositoryUseCase,
  private val navigator: SearchRepositoryNavigator,
  private val scope: CoroutineScope,
) : SearchRepositoryContract.Presenter {
  override fun onSearchAction(query: String) {
    searchRepositoryUseCase(query)
      .onEach {
        view.showRepositories(it)
      }
      .launchIn(scope)
  }

  override fun onRepositorySelected(
    repository: Repository,
  ) {
    navigator.toRepositoryDetail(repository = repository)
  }
}
