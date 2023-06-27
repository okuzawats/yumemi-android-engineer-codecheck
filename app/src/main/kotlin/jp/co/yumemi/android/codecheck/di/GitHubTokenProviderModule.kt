package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.token.DefaultGitHubTokenProvider
import jp.co.yumemi.android.codecheck.token.GitHubTokenProvider

@Module
@InstallIn(SingletonComponent::class)
class GitHubTokenProviderModule {
  @Provides
  fun provideGitHubTokenProvider(
    impl: DefaultGitHubTokenProvider,
  ): GitHubTokenProvider {
    return impl
  }
}
