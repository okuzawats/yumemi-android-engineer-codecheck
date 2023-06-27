package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.datasource.search.DefaultSearchDataSource
import jp.co.yumemi.android.codecheck.repository.search.SearchDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SearchDataSourceModule {
  @Provides
  @Singleton
  fun provideSearchDataSource(
    impl: DefaultSearchDataSource,
  ): SearchDataSource {
    return impl
  }
}
