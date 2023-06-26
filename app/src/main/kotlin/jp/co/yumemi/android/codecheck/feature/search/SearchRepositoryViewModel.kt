/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.search

import androidx.lifecycle.ViewModel
import jp.co.yumemi.android.codecheck.Repository
import kotlinx.coroutines.runBlocking

/**
 * TwoFragment で使う
 */
class SearchRepositoryViewModel : ViewModel() {

  // 検索結果
  fun searchResults(inputText: String): List<Repository> = runBlocking {
    return@runBlocking emptyList()

    // FIXME 以下は要修正
//    val client = HttpClient(Android)
//
//    return@runBlocking GlobalScope.async {
//      val response: HttpResponse = client?.get(
//        "https://api.github.com/search/repositories"
//      ) {
//        header("Accept", "application/vnd.github.v3+json")
//        parameter("q", inputText)
//      }
//
//      val jsonBody = JSONObject(response.receive<String>())
//
//      val jsonItems = jsonBody.optJSONArray("items")!!
//
//      val items = mutableListOf<item>()
//
//      /**
//       * アイテムの個数分ループする
//       */
//      for (i in 0 until jsonItems.length()) {
//        val jsonItem = jsonItems.optJSONObject(i)!!
//        val name = jsonItem.optString("full_name")
//        val ownerIconUrl = jsonItem.optJSONObject("owner")!!.optString(
//          "avatar_url"
//        )
//        val language = jsonItem.optString("language")
//        val stargazersCount = jsonItem.optLong("stargazers_count")
//        val watchersCount = jsonItem.optLong("watchers_count")
//        val forksCount = jsonItem.optLong("forks_conut")
//        val openIssuesCount = jsonItem.optLong("open_issues_count")
//
//        items.add(
//          item(
//            name = name,
//            ownerIconUrl = ownerIconUrl,
//            language = context.getString(
//              R.string.written_language,
//              language
//            ),
//            stargazersCount = stargazersCount,
//            watchersCount = watchersCount,
//            forksCount = forksCount,
//            openIssuesCount = openIssuesCount
//          )
//        )
//      }
//
//      lastSearchDate = Date()
//
//      return@async items.toList()
//    }.await()
  }
}