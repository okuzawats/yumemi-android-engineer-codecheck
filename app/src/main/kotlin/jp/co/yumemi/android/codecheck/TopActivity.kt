/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class TopActivity : AppCompatActivity(R.layout.activity_top) {

  companion object {
    lateinit var lastSearchDate: Date
  }
}
