package jp.co.yumemi.android.codecheck.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryContract
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryFragment
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryNavigator
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryPresenter
import jp.co.yumemi.android.codecheck.navigation.DefaultSearchRepositoryNavigator
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(FragmentComponent::class)
class SearchRepositoryFragmentModule {
  @Provides
  @FragmentScoped
  fun provideSearchRepositoryFragment(
    fragment: Fragment,
  ): SearchRepositoryFragment = fragment as SearchRepositoryFragment

  @Provides
  @FragmentScoped
  fun provideSearchRepositoryView(
    searchRepositoryFragment: SearchRepositoryFragment,
  ): SearchRepositoryContract.View = searchRepositoryFragment

  @Provides
  @FragmentScoped
  fun provideFragmentScope(
    searchRepositoryFragment: SearchRepositoryFragment,
  ): CoroutineScope = searchRepositoryFragment.lifecycleScope

  @Provides
  @FragmentScoped
  fun provideSearchRepositoryPresenter(
    searchRepositoryPresenter: SearchRepositoryPresenter,
  ): SearchRepositoryContract.Presenter = searchRepositoryPresenter

  @Provides
  @FragmentScoped
  fun provideSearchRepositoryNavigator(
    searchRepositoryNavigator: DefaultSearchRepositoryNavigator,
  ): SearchRepositoryNavigator = searchRepositoryNavigator
}
