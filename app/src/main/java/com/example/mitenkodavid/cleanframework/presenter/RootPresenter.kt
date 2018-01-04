package com.example.mitenkodavid.cleanframework.presenter

import android.support.annotation.CallSuper
import com.example.mitenkodavid.cleanframework.model.ClickEvent
import com.example.mitenkodavid.cleanframework.model.MVPObservable
import com.example.mitenkodavid.cleanframework.state.RootFragmentState
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragmentView
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * Created by Real Estate Webmasters on 12/28/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
abstract class RootPresenter<S : RootFragmentState, V: RootFragmentView>
    (var state: S, var view: V) : Observer<MVPObservable> {
    // region Rendering functions
    /**
     * Extension on the state that will execute an update
     */
    fun S.update(newState: S) {
        val oldState = state
        render(view, newState, oldState)
        state = newState
    }

    /**
     * Renders the new state onto the view
     */
    @CallSuper
    open fun render(view: V, newState: S, oldState: S) {
        if (newState.loaded != oldState.loaded) {
            view.setProgressBarVisible(!newState.loaded)
        }
    }
    // endregion

    // region Observer Functions
    override fun onComplete() {
        Timber.e("onComplete")
        Timber.e("State:" + state.loaded)
    }


    override fun onSubscribe(@NonNull d: Disposable) {
        Timber.e("onSubscribe: " + d.toString())
    }
    // endregion
}