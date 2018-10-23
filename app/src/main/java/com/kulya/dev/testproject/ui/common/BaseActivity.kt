package com.kulya.dev.testproject.ui.common

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), HasSupportFragmentInjector{
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
    }





    fun showDialogFragment(dialogFragment: DialogFragment, tag: String, args: Bundle = Bundle.EMPTY) {
        dialogFragment.arguments = args
        dialogFragment.show(supportFragmentManager, tag)
    }

    override fun supportFragmentInjector() = fragmentInjector

    abstract fun getContentView(): Int


}