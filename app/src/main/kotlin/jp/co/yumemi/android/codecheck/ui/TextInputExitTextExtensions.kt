package jp.co.yumemi.android.codecheck.ui

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

/**
 * IMEの検索実行に対するイベントリスナー
 */
fun TextInputEditText.setOnSearchActionListener(
  onSearchAction: (textView: TextView) -> Unit,
) {
  this.setOnEditorActionListener { editText, action, _ ->
    if (action == EditorInfo.IME_ACTION_SEARCH) {
      onSearchAction(editText)
      return@setOnEditorActionListener true
    }
    return@setOnEditorActionListener false
  }
}
