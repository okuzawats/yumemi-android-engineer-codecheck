package jp.co.yumemi.android.codecheck

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * ひとつのリポジトリを表すデータモデル
 */
@Parcelize
data class Repository(
  val name: String,
  val ownerIconUrl: String,
  val language: String,
  val stargazersCount: Long,
  val watchersCount: Long,
  val forksCount: Long,
  val openIssuesCount: Long,
) : Parcelable
