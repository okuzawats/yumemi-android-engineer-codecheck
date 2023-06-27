package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.repository.search.DefaultSearchResultRepository
import jp.co.yumemi.android.codecheck.usecase.search.SearchResultRepository

@Module
@InstallIn(SingletonComponent::class)
class SearchResultRepositoryModule {
  @Provides
  fun provideSearchResultRepository(
    impl: DefaultSearchResultRepository,
  ): SearchResultRepository {
    return impl
  }
}
