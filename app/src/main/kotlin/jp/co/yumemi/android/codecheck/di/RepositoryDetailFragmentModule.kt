package jp.co.yumemi.android.codecheck.di

import androidx.fragment.app.Fragment
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.navArgs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import jp.co.yumemi.android.codecheck.feature.detail.RepositoryDetailContract
import jp.co.yumemi.android.codecheck.feature.detail.RepositoryDetailFragment
import jp.co.yumemi.android.codecheck.feature.detail.RepositoryDetailFragmentArgs
import jp.co.yumemi.android.codecheck.feature.detail.RepositoryDetailProvider
import jp.co.yumemi.android.codecheck.feature.detail.RepositoryDetailProviderImpl

@Module
@InstallIn(FragmentComponent::class)
class RepositoryDetailFragmentModule {
  @Provides
  @FragmentScoped
  fun provideRepositoryDetailFragment(
    fragment: Fragment,
  ): RepositoryDetailFragment {
    return fragment as RepositoryDetailFragment
  }

  @Provides
  @FragmentScoped
  fun provideRepositoryDetailView(
    fragment: RepositoryDetailFragment,
  ): RepositoryDetailContract.View {
    return fragment
  }

  @Provides
  @FragmentScoped
  fun provideNavArgs(
    fragment: RepositoryDetailFragment,
  ): NavArgsLazy<RepositoryDetailFragmentArgs> {
    return fragment.navArgs()
  }

  @Provides
  @FragmentScoped
  fun provideRepositoryDetailProvider(
    impl: RepositoryDetailProviderImpl,
  ): RepositoryDetailProvider {
    return impl
  }
}
