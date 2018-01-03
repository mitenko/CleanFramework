package com.example.mitenkodavid.cleanframework.ui.fragment.fragmentA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mitenkodavid.cleanframework.R
import com.example.mitenkodavid.cleanframework.R.id.fab
import com.example.mitenkodavid.cleanframework.R.id.inputText
import com.example.mitenkodavid.cleanframework.presenter.PresenterA
import com.example.mitenkodavid.cleanframework.presenter.RootPresenter
import com.example.mitenkodavid.cleanframework.state.FragmentAState
import com.example.mitenkodavid.cleanframework.state.StateA
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragment
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragmentView
import kotlinx.android.synthetic.main.fragment_a.*

/**
 * Created by Real Estate Webmasters on 12/27/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
interface FragmentAView : RootFragmentView

class FragmentA<StateA>: RootFragment<StateA>(), FragmentAView {
    override val fragmentLayoutId: Int = R.layout.fragment_a

    /**
     * https://www.raywenderlich.com/169885/android-fragments-tutorial-introduction-2
     */
    companion object {
        fun newInstance(): FragmentA<StateA> {
            return FragmentA()
        }
    }

    /**
     *
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.presenter = PresenterA(StateA(), this)
        subscribeTextView(inputText)
        subscribeButton(fab)
    }
}