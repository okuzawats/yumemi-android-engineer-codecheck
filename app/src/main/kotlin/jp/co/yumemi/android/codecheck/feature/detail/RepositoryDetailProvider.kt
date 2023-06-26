package jp.co.yumemi.android.codecheck.feature.detail

import androidx.navigation.fragment.navArgs
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
  private val repositoryDetailFragment: RepositoryDetailFragment,
): RepositoryDetailProvider {
  override fun provide(): Repository {
    val navArgs = repositoryDetailFragment
      .navArgs<RepositoryDetailFragmentArgs>()
    return navArgs.value.repository
  }
}
