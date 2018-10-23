package com.kulya.dev.testproject.ui.country.presenter

import com.kulya.dev.testproject.ui.common.presenter.BasePresenter
import com.kulya.dev.testproject.ui.country.interactor.CountryInteractor
import com.kulya.dev.testproject.ui.country.view.CountryFragmentView
import com.kulya.dev.testproject.ui.main.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CountryPresenterImpl @Inject constructor(
    view:CountryFragmentView,
    val countryInteractor: CountryInteractor
):BasePresenter<CountryFragmentView>(view), CountryPresenter {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun getCountryList() {
        compositeDisposable.add(
            countryInteractor.getCountryList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    view.startLoading()
                }
                .subscribe (
                    {
                        view.finishLoading()
                        view.populateList(it)
                    },
                    {
                        view.finishLoading()
                        view.onError(it.message)
                    }
                )

        )
    }

    override fun onEnd() {
        compositeDisposable.clear()
    }
}