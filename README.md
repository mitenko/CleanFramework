# Clean MVP 
### Goal
To build an MVP Fragment swapping framework that minimizes boilerplate code and minimizes all code in general
### Key Tools
Kotlin<br>
RxKotlin<br>
Retrofit2<br>
Dagger

# Implementation Details
#### Data Flow
Presenters implement Observer\<MVPObservable> and are to be used to subscribe to all UI events (via RxKotlin) as well as all Retrofit2 observables

#### State Save / Restore
State save / restore is managed in the presenter via <a href="https://developer.android.com/reference/android/support/v4/app/FragmentManager.FragmentLifecycleCallbacks.html">FragmentLifecycleCallbacks</a> and Kotlin's <a href="https://android.jlelse.eu/yet-another-awesome-kotlin-feature-parcelize-5439718ba220">@Parcelize</a>

