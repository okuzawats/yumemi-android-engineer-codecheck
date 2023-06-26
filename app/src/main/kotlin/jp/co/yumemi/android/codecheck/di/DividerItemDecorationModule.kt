package jp.co.yumemi.android.codecheck.di

import androidx.recyclerview.widget.DividerItemDecoration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import jp.co.yumemi.android.codecheck.ui.VerticalDividerItemDecoration

@Module
@InstallIn(FragmentComponent::class)
class DividerItemDecorationModule {
  @Provides
  fun provideDividerItemDecoration(
    verticalDividerItemDecoration: VerticalDividerItemDecoration,
  ): DividerItemDecoration = verticalDividerItemDecoration
}
