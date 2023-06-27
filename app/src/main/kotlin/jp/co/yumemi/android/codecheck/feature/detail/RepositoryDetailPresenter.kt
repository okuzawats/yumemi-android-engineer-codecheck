package jp.co.yumemi.android.codecheck.feature.detail

import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

/**
 * [RepositoryDetailContract.Presenter]の実装クラス
 */
@FragmentScoped
class RepositoryDetailPresenter @Inject constructor(
  private val view: RepositoryDetailContract.View,
  private val mapper: RepositoryDetailMapper,
  private val repositoryDetailProvider: RepositoryDetailProvider,
) : RepositoryDetailContract.Presenter {
  override fun onEntered() {
    val repository = repositoryDetailProvider.provide()
    view.showRepository(
      repository = mapper.toPresentation(repository),
    )
  }
}
