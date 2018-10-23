package com.kulya.dev.testproject.ui.common.presenter

import android.os.Bundle

interface Presenter {

    fun onStart(savedInstanceState: Bundle?) = Unit

    fun onResume() = Unit

    fun onPause() = Unit


    fun onSaveInstanceState(outState: Bundle) = Unit


    fun onEnd() = Unit
}