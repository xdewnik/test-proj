package com.kulya.dev.testproject.ui.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDialogFragment
import com.kulya.dev.testproject.R
import com.kulya.dev.testproject.util.emptyString
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment : AppCompatDialogFragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(AppCompatDialogFragment.STYLE_NO_TITLE, R.style.Theme_AppCompat_Dialog_MinWidth)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    open fun getTitle(): String = emptyString


    open fun getToolbarMenu(): Int = R.menu.empty_toolbar



    override fun supportFragmentInjector() = childFragmentInjector

}