package com.anisimov.animalhugger.ui.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.anisimov.animalhugger.MainActivity
import com.anisimov.animalhugger.R

class LikeHistoryFragment : Fragment(R.layout.like_history_fragment), MavericksView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).fab.apply {
            setImageResource(R.drawable.icon_triangle)
            setOnClickListener { activity?.onBackPressed() }
        }
    }

    override fun invalidate() {

    }

}
