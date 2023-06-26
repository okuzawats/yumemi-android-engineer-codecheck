package jp.co.yumemi.android.codecheck.ui

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * LinearLayoutManagerのorientation = Verticalに対するDividerItemDecoration
 */
class VerticalDividerItemDecoration @Inject constructor(
  @ApplicationContext context: Context,
): DividerItemDecoration(context, RecyclerView.VERTICAL)
