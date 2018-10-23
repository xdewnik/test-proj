package com.kulya.dev.testproject.ui.common.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kulya.dev.testproject.ui.common.presenter.Presenter
import javax.inject.Inject

abstract class BaseViewFragment<P : Presenter> : BaseFragment(), MVPView {


    @Inject
    protected lateinit var presenter: P


    protected lateinit var aView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.CustomDialog)
        aView = inflater.inflate(getFragmentLayout(), container, false)
        return aView
    }



    abstract fun getFragmentLayout(): Int

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)


        presenter.onStart(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        presenter.onEnd()
        super.onDestroyView()
    }
}