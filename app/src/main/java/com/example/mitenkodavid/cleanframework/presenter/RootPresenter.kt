package com.example.mitenkodavid.cleanframework.presenter

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import com.example.mitenkodavid.cleanframework.model.MVPObservable
import com.example.mitenkodavid.cleanframework.state.RootFragmentState
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragmentView
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class RootPresenter<S : RootFragmentState, V: RootFragmentView>
    (var state: S, var view: V) : Observer<MVPObservable>, FragmentManager.FragmentLifecycleCallbacks() {
    // region Rendering functions
    /**
     * Prepares the state variables for a render pass
     */
    fun updateState(newState: S) {
        if (newState == state) {
            return
        }
        val oldState = state
        render(view, newState, oldState)
        state = newState
    }

    /**
     * Renders the new state onto the view
     */
    @CallSuper
    open fun render(view: V, newState: S, oldState: S) {
        if (newState.loading != oldState.loading) {
            view.setProgressBarVisible(newState.loading)
        }
    }
    // endregion

    // region Observer Functions
    override fun onComplete() {
        Timber.e("onComplete")
        Timber.e("State:" + state.loading)
    }


    override fun onSubscribe(@NonNull d: Disposable) {}
    // endregion

    // region FragmentLifecycleCallbacks
    /**
     * Use the Fragment Lifecycle Callbacks to store and restore the state
     */
    /**
     * Restore the state at the point when we know we can render it on the view in the same pass
     */
    override fun onFragmentViewCreated
            (fragMan: FragmentManager?, frag: Fragment?, view: View?, savedInstanceState: Bundle?) {
        val restoredState = savedInstanceState?.getParcelable(state.tag) ?: state
        updateState(restoredState)
        super.onFragmentViewCreated(fragMan, frag, view, savedInstanceState)
    }

    /**
     * Save the state
     */
    override fun onFragmentSaveInstanceState(fragMan: FragmentManager, frag: Fragment, outState: Bundle) {
        outState.putParcelable(state.tag, state)
        super.onFragmentSaveInstanceState(fragMan, frag, outState)
    }
    // endregion
}