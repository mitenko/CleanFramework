package com.example.mitenkodavid.cleanframework.state

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Real Estate Webmasters on 1/2/2018.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
/**
 * Contains the core state variables
 * Accessible at the RootPresenter level
 */
abstract class RootFragmentState(
        open val tag: String = "unknown",
        open val loading: Boolean = false,
        open val error: Throwable?) : Parcelable

@Parcelize
data class StateA(
        val clicked: Boolean = false,
        val inputString: String = "",
        val outputString: String = "",
        override val tag: String = "A",
        override val loading: Boolean = false,
        override val error: Throwable? = null): RootFragmentState(tag, loading, error), Parcelable