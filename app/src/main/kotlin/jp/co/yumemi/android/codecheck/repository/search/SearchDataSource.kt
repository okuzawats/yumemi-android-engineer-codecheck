package jp.co.yumemi.android.codecheck.repository.search

import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
  suspend fun searchRepository(query: String): Flow<List<Repository>>
}
