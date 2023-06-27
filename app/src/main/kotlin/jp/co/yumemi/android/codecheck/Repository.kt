package jp.co.yumemi.android.codecheck

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * ひとつのリポジトリを表すデータモデル
 */
@Parcelize
data class Repository(
  val ownerIconUrl: String,
  val description: String,
  val forksCount: Int,
  val stargazersCount: Int,
) : Parcelable
