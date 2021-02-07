package com.anisimov.animalhugger.ui.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Slide
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.anisimov.animalhugger.MainActivity
import com.anisimov.animalhugger.R
import com.anisimov.animalhugger.databinding.*
import com.anisimov.animalhugger.model.Animal
import com.anisimov.animalhugger.model.Animals
import com.anisimov.animalhugger.ui.history.LikeHistoryFragment
import com.anisimov.animalhugger.ui.main.adapters.ContentHolderAdapter
import com.anisimov.animalhugger.ui.main.adapters.FeaturedAdapter
import com.anisimov.animalhugger.utils.viewBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.absoluteValue

class MainFragment : Fragment(R.layout.main_fragment), MavericksView {

    companion object {
        fun newInstance() = MainFragment()

        private const val DELAY_AUTO_PAGE_CHANGE_MS = 2_500L
    }

    private val viewModel: MainViewModel by fragmentViewModel()
    private val binding: MainFragmentBinding by viewBinding()

    private val activity: MainActivity
        get() = requireActivity() as MainActivity

    private val handler = Handler(Looper.getMainLooper())

    private val featuredPageScrollRunnable = object : Runnable {
        override fun run() {
            binding.featuredViewPager.apply {
                currentItem = if (currentItem == adapter?.itemCount?.dec()) {
                    0
                } else {
                    ++currentItem
                }
            }

            handler.postDelayed(this, DELAY_AUTO_PAGE_CHANGE_MS)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity.fab.apply {
            setImageResource(R.drawable.icon_hugme)
            setOnClickListener {
                openLikeHistory()
            }
        }

        binding.appBarLayout.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (verticalOffset.absoluteValue - appBarLayout.totalScrollRange == 0) {
                    activity.fab.show()
                } else {
                    activity.fab.hide()
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(featuredPageScrollRunnable, DELAY_AUTO_PAGE_CHANGE_MS)
    }

    override fun onPause() {
        handler.removeCallbacksAndMessages(null)

        super.onPause()
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            initFeaturedViewPager(state.featuredSpecies)
            initContentViewPager(
                availableSpecies = state.availableSpecies,
                animals = state.animals,
            )

        }
    }

    private fun initFeaturedViewPager(featuredSpecies: List<String>) {
        binding.featuredViewPager.adapter = FeaturedAdapter().apply {
            submitList(featuredSpecies)
        }

        TabLayoutMediator(
            binding.featuredTabLayout,
            binding.featuredViewPager,
        ) { tab, _ ->
            binding.featuredViewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

    private fun initContentViewPager(availableSpecies: List<String>, animals: List<Animals>) {
        binding.contentViewPager.adapter = ContentHolderAdapter(
            availableSpecies = availableSpecies,
            onTabSelected = { species ->
                binding.contentViewPager.setCurrentItem(
                    animals.indexOfFirst { it.species == species },
                    false
                )

            }
        ).also { it.submitList(animals) }
    }

    private fun openLikeHistory() {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                LikeHistoryFragment().apply {
                    exitTransition = Slide(Gravity.RIGHT)
                    enterTransition = Slide(Gravity.RIGHT)
                }
            )
            .addToBackStack(LikeHistoryFragment::class.simpleName)
            .commit()
    }

}
