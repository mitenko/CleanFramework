package com.example.mitenkodavid.cleanframework.state

import android.os.Parcelable
import com.example.mitenkodavid.cleanframework.ui.fragment.RootFragment
import com.example.mitenkodavid.cleanframework.ui.fragment.fragmentA.FragmentA
import kotlinx.android.parcel.Parcelize

/**
 * Contains the core state variables
 * Accessible at the RootPresenter level
 */
abstract class RootFragmentState(
        open val tag: String = RootFragment.fragmentTag + "state",
        open val loading: Boolean = false,
        open val error: Throwable?) : Parcelable

@Parcelize
data class StateA(
        val clicked: Boolean = false,
        val inputString: String = "",
        val outputString: String = "",
        override val tag: String = FragmentA.fragmentTag + "state",
        override val loading: Boolean = false,
        override val error: Throwable? = null): RootFragmentState(tag, loading, error), Parcelable