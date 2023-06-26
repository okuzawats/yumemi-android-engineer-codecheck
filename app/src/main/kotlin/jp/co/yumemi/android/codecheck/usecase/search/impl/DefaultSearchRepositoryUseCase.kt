package jp.co.yumemi.android.codecheck.usecase.search.impl

import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.usecase.search.SearchRepositoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DefaultSearchRepositoryUseCase @Inject constructor() :
  SearchRepositoryUseCase {
  override fun invoke(query: String): Flow<List<Repository>> = flow {
    // TODO
    emit(
      listOf(
        Repository(
          name = "this is my repository!",
          ownerIconUrl = "",
          language = "",
          stargazersCount = 42L,
          watchersCount = 42L,
          forksCount = 42L,
          openIssuesCount = 42L,
        ),
      ),
    )
  }
}
