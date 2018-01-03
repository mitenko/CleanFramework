package com.example.mitenkodavid.cleanframework.presenter

import com.example.mitenkodavid.cleanframework.model.ClickEvent
import com.example.mitenkodavid.cleanframework.model.MVPObservable
import com.example.mitenkodavid.cleanframework.state.RootFragmentState
import com.example.mitenkodavid.cleanframework.state.StateA
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragmentView
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * Created by Real Estate Webmasters on 12/28/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
open class RootPresenter<S : RootFragmentState>
    (var state: S, var view: RootFragmentView) : Observer<MVPObservable> {
    // region Rendering functions

    // endregion
    /**
     * up
     */
    fun S.update(newState: S) {


    }

    // region Observer Functions
    override fun onComplete() {
        Timber.e("onComplete")
        Timber.e("State:" + state.loaded)
    }

    override fun onNext(observable: MVPObservable) {
        Timber.e("OnNext: " + observable.toString())
        if (observable is ClickEvent) {
            view.progressBarVisible(false)
        }
    }

    override fun onError(e: Throwable) {
        Timber.e("onError: " + e.toString())
    }

    override fun onSubscribe(@NonNull d: Disposable) {
        Timber.e("onSubscribe: " + d.toString())
    }
    // endregion

}