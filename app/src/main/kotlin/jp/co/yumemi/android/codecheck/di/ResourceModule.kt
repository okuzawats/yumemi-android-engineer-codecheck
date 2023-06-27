package jp.co.yumemi.android.codecheck.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
class ResourceModule {
  @Provides
  fun provideResource(
    @ApplicationContext context: Context,
  ): Resources = context.resources
}
