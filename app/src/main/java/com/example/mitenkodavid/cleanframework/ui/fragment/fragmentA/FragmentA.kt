package com.example.mitenkodavid.cleanframework.ui.fragment.fragmentA

import android.os.Bundle
import android.view.View
import com.example.mitenkodavid.cleanframework.R
import com.example.mitenkodavid.cleanframework.presenter.PresenterA
import com.example.mitenkodavid.cleanframework.state.StateA
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragment
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragmentView
import kotlinx.android.synthetic.main.fragment_a.*

interface FragmentAView : RootFragmentView

class FragmentA: RootFragment<PresenterA, StateA, FragmentAView>(), FragmentAView {
    override val fragmentLayoutId: Int = R.layout.fragment_a
    init {
        presenter = PresenterA(StateA(), this)
    }

    /**
     * https://www.raywenderlich.com/169885/android-fragments-tutorial-introduction-2
     */
    companion object {
        var fragmentTag =
        fun newInstance(): FragmentA {
            return FragmentA()
        }
    }

    /**
     *
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeTextView(inputText)
        subscribeButton(fab)
    }
}