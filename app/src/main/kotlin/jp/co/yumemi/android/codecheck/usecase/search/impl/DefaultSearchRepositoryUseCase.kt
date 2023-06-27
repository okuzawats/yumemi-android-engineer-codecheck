package jp.co.yumemi.android.codecheck.usecase.search.impl

import jp.co.yumemi.android.codecheck.usecase.search.Repository
import jp.co.yumemi.android.codecheck.usecase.search.SearchRepositoryUseCase
import jp.co.yumemi.android.codecheck.usecase.search.SearchResultRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultSearchRepositoryUseCase @Inject constructor(
  private val searchResultRepository: SearchResultRepository,
) : SearchRepositoryUseCase {
  override suspend fun invoke(query: String): Flow<List<Repository>> {
    return searchResultRepository
      .search(query)
      .map { it.repositories }
      .map { repositories ->
        repositories.map {
          Repository(
            description = it.description,
            forkCount = it.forkCount,
            stargazerCount = it.stargazerCount,
          )
        }
      }
  }
}
