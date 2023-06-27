package jp.co.yumemi.android.codecheck.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.apollo.ApolloClientProvider
import jp.co.yumemi.android.codecheck.apollo.DefaultApolloClientProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApolloClientModule {
  @Provides
  fun provideApolloClientProvider(
    impl: DefaultApolloClientProvider,
  ): ApolloClientProvider {
    return impl
  }

  @Provides
  @Singleton
  fun provideApolloClient(
    apolloClientProvider: ApolloClientProvider,
  ): ApolloClient {
    return apolloClientProvider.provide()
  }
}
