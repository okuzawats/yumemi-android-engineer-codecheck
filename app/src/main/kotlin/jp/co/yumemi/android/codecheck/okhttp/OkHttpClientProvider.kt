package jp.co.yumemi.android.codecheck.okhttp

import jp.co.yumemi.android.codecheck.token.GitHubTokenProvider
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * OkHttpClientを提供するためのinterface
 */
interface OkHttpClientProvider {
  /**
   * OkHttpClientのインスタンスを返す
   */
  fun provide(): OkHttpClient
}

class DefaultOkHttpClientProvider @Inject constructor(
  private val gitHubTokenProvider: GitHubTokenProvider
) : OkHttpClientProvider {
  override fun provide(): OkHttpClient {
    val token = gitHubTokenProvider.provide()
    return OkHttpClient.Builder()
      .authenticator { _, response ->
        response.request.newBuilder()
          .addHeader("Authorization", "Bearer $token")
          .build()
      }.build()
  }
}
