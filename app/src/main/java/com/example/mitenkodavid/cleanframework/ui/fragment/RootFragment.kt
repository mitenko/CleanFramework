package com.example.mitenkodavid.cleanframework.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mitenkodavid.cleanframework.R
import com.example.mitenkodavid.cleanframework.model.ClickEvent
import com.example.mitenkodavid.cleanframework.model.TextEvent
import com.example.mitenkodavid.cleanframework.presenter.RootPresenter
import com.example.mitenkodavid.cleanframework.state.RootFragmentState
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_root.*
import java.util.concurrent.TimeUnit

/**
 * Created by Real Estate Webmasters on 12/27/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
/**
 * The Root Fragment View Interface
 */
interface RootFragmentView {
    fun progressBarVisible(visible:Boolean)
}

abstract class RootFragment<S,P>: Fragment(), RootFragmentView {
    protected lateinit var presenter: P
    protected abstract val fragmentLayoutId: Int

    // region Fragment Lifecycle
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        var rootContainer =
                inflater.inflate(R.layout.fragment_root, container, false) as ViewGroup
        inflater.inflate(fragmentLayoutId, rootContainer, true)
        return rootContainer
    }
    // endregion

    // region RootFragmentView implementations
    /**
     * Sets the visibility of the progress bar
     */
    override fun progressBarVisible(visible:Boolean) {
        progressBar.visibility =
                if (visible) View.VISIBLE else View.INVISIBLE
    }
    // endregion

    // region RxView functions
    /**
     * Subscribes the button to the presenter
     */
    protected fun subscribeButton(button: View) {
        RxView.clicks(button)
            .map{ ClickEvent(button.id) }
            .subscribe(presenter)
    }

    /**
     * Subscribes the text view to the presenter
     */
    protected fun subscribeTextView(textView: TextView) {
        val debounceTime =
                context?.resources?.getInteger(R.integer.textview_delay_ms)?.toLong() ?: 300

        RxTextView.afterTextChangeEvents(textView)
            .debounce(debounceTime, TimeUnit.MILLISECONDS)
            .map{text -> TextEvent(textView.id, text.editable().toString()) }
            .subscribe(presenter)
    }
    // endregion
}