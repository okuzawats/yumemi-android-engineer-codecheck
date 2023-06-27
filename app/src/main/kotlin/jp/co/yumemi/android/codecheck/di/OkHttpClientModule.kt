package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.android.codecheck.okhttp.DefaultOkHttpClientProvider
import jp.co.yumemi.android.codecheck.okhttp.OkHttpClientProvider
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OkHttpClientModule {
  @Provides
  fun provideOkHttpClientProvider(
    impl: DefaultOkHttpClientProvider,
  ): OkHttpClientProvider {
    return impl
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(
    okHttpClientProvider: OkHttpClientProvider,
  ): OkHttpClient {
    return okHttpClientProvider.provide()
  }
}
