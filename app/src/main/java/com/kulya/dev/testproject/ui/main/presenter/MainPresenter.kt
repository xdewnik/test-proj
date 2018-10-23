package com.kulya.dev.testproject.ui.main.presenter

import com.kulya.dev.testproject.ui.common.presenter.Presenter

interface MainPresenter :Presenter {
    fun handleDrawerOpen()

    fun handleDrawerClose()

}