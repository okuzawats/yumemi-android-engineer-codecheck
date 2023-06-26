/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.MainActivity.Companion.lastSearchDate
import jp.co.yumemi.android.codecheck.databinding.FragmentRepositoryDetailBinding

@AndroidEntryPoint
class RepositoryDetailFragment : Fragment(R.layout.fragment_repository_detail) {

  private val args: RepositoryDetailFragmentArgs by navArgs()

  private var binding: FragmentRepositoryDetailBinding? = null
  private val _binding get() = binding!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    Log.d("検索した日時", lastSearchDate.toString())

    binding = FragmentRepositoryDetailBinding.bind(view)

    var item = args.item

    _binding.ownerIconView.load(item.ownerIconUrl)
    _binding.nameView.text = item.name
    _binding.languageView.text = item.language
    _binding.starsView.text = "${item.stargazersCount} stars"
    _binding.watchersView.text = "${item.watchersCount} watchers"
    _binding.forksView.text = "${item.forksCount} forks"
    _binding.openIssuesView.text = "${item.openIssuesCount} open issues"
  }
}
