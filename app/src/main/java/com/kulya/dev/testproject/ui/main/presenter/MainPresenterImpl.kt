package com.kulya.dev.testproject.ui.main.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.kulya.dev.testproject.scopes.PerActivity
import com.kulya.dev.testproject.ui.common.presenter.BasePresenter
import com.kulya.dev.testproject.ui.main.view.MainView
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    view: MainView
): BasePresenter<MainView>(view), MainPresenter {


    private var isDrawerOpened = false



    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        if(isDrawerOpened){
            view.setArrowState()
        }else{
            view.setHamburgerState()
        }
    }



    override fun handleDrawerOpen() {
        isDrawerOpened = true

    }

    override fun handleDrawerClose() {
        isDrawerOpened = false
    }
}