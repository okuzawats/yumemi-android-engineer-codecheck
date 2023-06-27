package jp.co.yumemi.android.codecheck.apollo

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * ApolloClientを提供するためのinterface
 */
interface ApolloClientProvider {
  /**
   * ApolloClientを返す
   */
  fun provide(): ApolloClient
}

class DefaultApolloClientProvider @Inject constructor(
  private val okHttpClient: OkHttpClient,
) : ApolloClientProvider {
  override fun provide(): ApolloClient {
    return ApolloClient.Builder()
      .serverUrl("https://api.github.com/graphql")
      .okHttpClient(okHttpClient)
      .build()
  }
}
