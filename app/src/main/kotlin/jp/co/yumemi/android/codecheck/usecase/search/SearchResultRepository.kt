package jp.co.yumemi.android.codecheck.usecase.search

import kotlinx.coroutines.flow.Flow

interface SearchResultRepository {
  suspend fun search(query: String): Flow<SearchResult>
}
