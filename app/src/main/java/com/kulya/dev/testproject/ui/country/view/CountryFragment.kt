package com.kulya.dev.testproject.ui.country.view

import android.os.Bundle
import android.view.View
import com.kulya.dev.testproject.R
import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.ui.common.view.BaseViewFragment
import com.kulya.dev.testproject.ui.country.presenter.CountryPresenter
import com.kulya.dev.testproject.util.WrapContentLinearLayoutManager
import com.kulya.dev.testproject.util.hide
import com.kulya.dev.testproject.util.show
import com.kulya.dev.testproject.util.showToast
import kotlinx.android.synthetic.main.fragment_country.*
import android.graphics.drawable.PictureDrawable
import com.bumptech.glide.Glide
import android.support.v4.view.ViewCompat.animate



class CountryFragment: BaseViewFragment<CountryPresenter>(), CountryFragmentView, CountryAdapter.CountryAdapterClickListener{
    private val LAYOUT = R.layout.fragment_country

    private var countryAdapter: CountryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCountryList()
    }



    override fun startLoading() {
        progress_bar.show()
    }

    override fun finishLoading() {
        progress_bar.hide()
    }

    override fun onError(message: String?) {
        context?.showToast(message!!)
    }

    override fun populateList(countryList: MutableList<Country>) {
        countryAdapter?.update(countryList) ?: this setUpRecyclerView countryList
    }


    private infix fun setUpRecyclerView(countryList:MutableList<Country>){
        countryAdapter = CountryAdapter(countryList, this)
        with(country_recycler){
            layoutManager = WrapContentLinearLayoutManager(context, WrapContentLinearLayoutManager.VERTICAL,false)
            adapter = countryAdapter
            scheduleLayoutAnimation()
        }
    }


    override fun onItemClick(country: Country) {
        context?.showToast(country.name)
    }

    override fun getFragmentLayout() = LAYOUT
}