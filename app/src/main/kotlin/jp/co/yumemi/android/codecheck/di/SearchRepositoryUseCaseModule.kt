package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.usecase.search.SearchRepositoryUseCase
import jp.co.yumemi.android.codecheck.usecase.search.impl.DefaultSearchRepositoryUseCase

@Module
@InstallIn(SingletonComponent::class)
class SearchRepositoryUseCaseModule {
  @Provides
  fun provideSearchRepositoryUseCase(
    impl: DefaultSearchRepositoryUseCase,
  ): SearchRepositoryUseCase = impl
}
