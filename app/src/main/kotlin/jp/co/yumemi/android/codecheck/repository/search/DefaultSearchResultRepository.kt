package jp.co.yumemi.android.codecheck.repository.search

import jp.co.yumemi.android.codecheck.usecase.search.Repository
import jp.co.yumemi.android.codecheck.usecase.search.SearchResult
import jp.co.yumemi.android.codecheck.usecase.search.SearchResultRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultSearchResultRepository @Inject constructor(
  private val searchDataSource: SearchDataSource,
) : SearchResultRepository {
  override suspend fun search(query: String): Flow<SearchResult> {
    return searchDataSource
      .searchRepository(query = query)
      .map { repositories ->
        SearchResult(
          repositories = repositories.map {
            Repository(
              description = it.description,
              forkCount = it.forkCount,
              stargazerCount = it.stargazerCount,
            )
          },
        )
      }
  }
}
