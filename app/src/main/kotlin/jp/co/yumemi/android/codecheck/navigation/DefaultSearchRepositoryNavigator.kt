package jp.co.yumemi.android.codecheck.navigation

import androidx.navigation.fragment.findNavController
import jp.co.yumemi.android.codecheck.Repository
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryFragment
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryFragmentDirections
import jp.co.yumemi.android.codecheck.feature.search.SearchRepositoryNavigator
import javax.inject.Inject

/**
 * リポジトリ検索画面のナビゲーションの実装クラス
 */
class DefaultSearchRepositoryNavigator @Inject constructor(
  private val fragment: SearchRepositoryFragment,
) : SearchRepositoryNavigator {
  override fun toRepositoryDetail(repository: Repository) {
    val action = SearchRepositoryFragmentDirections.toRepositoryDetail(
      repository = repository,
    )
    fragment.findNavController().navigate(action)
  }
}
