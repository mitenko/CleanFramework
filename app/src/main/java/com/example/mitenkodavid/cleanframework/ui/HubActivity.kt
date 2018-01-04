package com.example.mitenkodavid.cleanframework.ui

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.mitenkodavid.cleanframework.R
import com.example.mitenkodavid.cleanframework.ui.fragment.fragmentA.FragmentA

class HubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hub)
        if (supportFragmentManager.findFragmentByTag(FragmentA.fragmentTag) == null) {
            supportFragmentManager.inTransaction {
                add(R.id.fragmentContainer, FragmentA.newInstance(), FragmentA.fragmentTag) }
        }
    }

    /**
     * Extension function to simplify fragment transaction calls
     */
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }
}
