package jp.co.yumemi.android.codecheck.feature.search

import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.usecase.search.SearchRepositoryUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * [SearchRepositoryContract.Presenter]の実装クラス
 *
 * FragmentのviewLifecycleOwnerのlifecycleScopeは
 * Fragment生成時には取得できないため、インスタンスの取得を遅延させる必要がある。
 */
class SearchRepositoryPresenter @Inject constructor(
  private val view: SearchRepositoryContract.View,
  private val searchRepositoryUseCase: SearchRepositoryUseCase,
  private val navigator: SearchRepositoryNavigator,
  private val scope: dagger.Lazy<CoroutineScope>,
) : SearchRepositoryContract.Presenter {
  override fun onSearchAction(
    query: String,
  ) {
    searchRepositoryUseCase(query)
      .onEach(view::showRepositories)
      .launchIn(scope.get())
  }

  override fun onRepositorySelected(
    repository: Repository,
  ) {
    navigator.toRepositoryDetail(repository = repository)
  }
}
