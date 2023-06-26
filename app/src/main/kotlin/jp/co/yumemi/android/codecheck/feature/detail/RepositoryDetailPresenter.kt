package jp.co.yumemi.android.codecheck.feature.detail

import javax.inject.Inject

class RepositoryDetailPresenter @Inject constructor(
  private val repositoryDetailProvider: RepositoryDetailProvider,
): RepositoryDetailContract.Presenter {
}
