package jp.co.yumemi.android.codecheck.feature.detail

import androidx.navigation.NavArgsLazy
import jp.co.yumemi.android.codecheck.Repository
import javax.inject.Inject

/**
 * リポジトリ詳細を提供するためのinterface
 */
interface RepositoryDetailProvider {
  /**
   * リポジトリを返す
   */
  fun provide(): Repository
}

class RepositoryDetailProviderImpl @Inject constructor(
  private val navArgs: NavArgsLazy<RepositoryDetailFragmentArgs>,
) : RepositoryDetailProvider {
  override fun provide(): Repository {
    return navArgs.value.repository
  }
}
