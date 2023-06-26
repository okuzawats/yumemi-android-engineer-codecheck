package jp.co.yumemi.android.codecheck.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * ViewGroupからレイアウトリソースのinflateを行う拡張関数
 */
fun ViewGroup.inflateView(@LayoutRes layoutResId: Int): View {
  return LayoutInflater.from(this.context).inflate(
    layoutResId,
    this,
    false,
  )
}
