package com.kulya.dev.testproject.ui.common.presenter

import com.kulya.dev.testproject.ui.common.view.MVPView


abstract class BasePresenter<out T : MVPView>

protected constructor(protected val view: T) : Presenter



