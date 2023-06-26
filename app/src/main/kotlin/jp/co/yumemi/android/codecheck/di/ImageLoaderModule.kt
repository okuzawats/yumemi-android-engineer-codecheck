package jp.co.yumemi.android.codecheck.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import jp.co.yumemi.android.codecheck.ui.ImageLoader
import jp.co.yumemi.android.codecheck.ui.ImageLoaderImpl

@Module
@InstallIn(FragmentComponent::class)
class ImageLoaderModule {
  @Provides
  fun provideImageLoader(
    impl: ImageLoaderImpl,
  ): ImageLoader {
    return impl
  }
}
