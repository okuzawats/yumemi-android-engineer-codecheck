package jp.co.yumemi.android.codecheck.token

import javax.inject.Inject

/**
 * GitHubのトークンを提供するためのinterface
 */
interface GitHubTokenProvider {
  /**
   * GitHubのトークンを返す
   */
  fun provide(): String
}

class DefaultGitHubTokenProvider @Inject constructor(): GitHubTokenProvider {
  override fun provide(): String {
    // TODO gradle.propertiesからトークンを取得する
    return "GitHubからトークンを取得してここに入れる"
  }
}
