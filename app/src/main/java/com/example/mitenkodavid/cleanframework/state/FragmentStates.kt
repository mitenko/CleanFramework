package com.example.mitenkodavid.cleanframework.state

/**
 * Created by Real Estate Webmasters on 1/2/2018.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */
open class RootFragmentState(open val loaded: Boolean, open val error: Throwable?)

data class StateA(
        val clicked: Boolean = false,
        val inputString: String = "",
        val outputString: String = "",
        override val loaded: Boolean = false,
        override val error: Throwable? = null): RootFragmentState(loaded, error)