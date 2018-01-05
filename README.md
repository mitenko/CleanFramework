# Clean MVP 
## Goal
To build an MVP Fragment swapping framework that minimizes boilerplate code and minimizes all code in general

## Key Tools
Kotlin<br>
RxKotlin<br>
Retrofit2<br>
Dagger

# Implementation Details
#### Data Flow
Presenters implement Observer\<MVPObservable> and are to be used to subscribe to all UI events (via RxKotlin) as well as all Retrofit2 observables

#### State Save / Restore
State save / restore is managed in the presenter via <a href="https://developer.android.com/reference/android/support/v4/app/FragmentManager.FragmentLifecycleCallbacks.html">FragmentLifecycleCallbacks</a> and Kotlin's <a href="https://android.jlelse.eu/yet-another-awesome-kotlin-feature-parcelize-5439718ba220">@Parcelize</a>

## Known Limitations
<p>Kotlin doesn't enable heritable data classes. This means the <a href="https://github.com/mitenko/CleanFramework/blob/master/app/src/main/java/com/example/mitenkodavid/cleanframework/state/FragmentStates.kt">RootFragmentState</a> can't be a data class.</p>
<p>As a consequence, the RootPresenter can't access the RootFragmentState as a data class and make use of the ```copy()``` function.
<p>All new states must be generated by the subclass, even though the RootPresenter is set up to handle 'root' events like errors and loading states.</p> 
<p>Ideally, the RootPresenter should be able to generate these new states as well, removing the necessity of handling these root events in the children fragments.</p>