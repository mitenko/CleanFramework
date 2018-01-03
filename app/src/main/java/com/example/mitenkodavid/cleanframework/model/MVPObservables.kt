package com.example.mitenkodavid.cleanframework.model

/**
 * Created by Real Estate Webmasters on 12/29/2017.
 * Copyright © Real Estate Webmasters. All rights reserved.
 */

/**
 * The root observable
 */
abstract class MVPObservable

/**
 * Broadcast Observables
 */

/**
 * View Observables
 */
abstract class ViewObservable(viewId: Int) : MVPObservable()
data class ClickEvent(val viewId: Int) : ViewObservable(viewId)
data class TextEvent(val viewId: Int, val text: String) : ViewObservable(viewId)

/**
 * Presenter Observables
 */
abstract class PresenterObservable() : MVPObservable()
data class LoadEvent(val loaded: Boolean) : PresenterObservable()

/**
 * Interactor Observables
 */
