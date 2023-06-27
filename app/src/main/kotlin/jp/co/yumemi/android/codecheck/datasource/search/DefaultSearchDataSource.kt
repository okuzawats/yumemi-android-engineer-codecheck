package jp.co.yumemi.android.codecheck.datasource.search

import com.apollographql.apollo3.ApolloClient
import jp.co.yumemi.android.codecheck.RepositoryQuery
import jp.co.yumemi.android.codecheck.repository.search.Repository
import jp.co.yumemi.android.codecheck.repository.search.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultSearchDataSource @Inject constructor(
  private val apolloClient: ApolloClient,
) : SearchDataSource {
  override suspend fun searchRepository(query: String): Flow<List<Repository>> {
    return apolloClient
      .query(RepositoryQuery(id = query))
      .toFlow()
      .map {
        it.data?.user?.repositories?.nodes
      }
      .map { node ->
        node?.filterNotNull()?.map {
          Repository(
            description = it.description,
            forkCount = it.forkCount,
            stargazerCount = it.stargazerCount,
          )
        } ?: emptyList()
      }
  }
}
