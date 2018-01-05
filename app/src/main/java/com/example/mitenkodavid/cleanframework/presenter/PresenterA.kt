package com.example.mitenkodavid.cleanframework.presenter

import com.example.mitenkodavid.cleanframework.R
import com.example.mitenkodavid.cleanframework.model.ClickEvent
import com.example.mitenkodavid.cleanframework.model.MVPObservable
import com.example.mitenkodavid.cleanframework.model.TextEvent
import com.example.mitenkodavid.cleanframework.state.StateA
import com.example.mitenkodavid.cleanframework.ui.fragment.fragmentA.FragmentAView
import timber.log.Timber


class PresenterA(state: StateA, view: FragmentAView)
    : RootPresenter<StateA, FragmentAView>(state, view) {
    // region Rendering functions
    override fun render(view: FragmentAView, newState: StateA, oldState: StateA) {
        super.render(view, newState, oldState)
        if (newState.loading != oldState.loading) {
            view.setProgressBarVisible(!newState.loading)
        }
    }
    // endregion

    // region Observer Functions
    override fun onNext(observable: MVPObservable) {
        /**
         * The FAB button has been clicked
         * Simulate successful REST response
         */
        if (observable is ClickEvent && observable.viewId == R.id.fab) {
            if (!state.inputString.isEmpty()) {
                /**
                 * put in retrofit request here
                 */
                updateState(state.copy(loading = true))
            }
        }

        /**
         * Something has been entered into the Input Text
         */
        if (observable is TextEvent && observable.viewId == R.id.inputText) {
            updateState(state.copy(inputString = observable.text))
        }
    }

    override fun onError(e: Throwable) {
        Timber.e("onError: " + e.toString())
    }
    // endregion
}