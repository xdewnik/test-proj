package com.kulya.dev.testproject.ui.country.view

import android.view.View
import com.bumptech.glide.Glide
import com.kulya.dev.testproject.R
import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.ui.common.adapter.BaseAdapter
import kotlinx.android.synthetic.main.item_country.view.*
import android.graphics.drawable.PictureDrawable
import android.support.v4.view.ViewCompat.animate
import com.bumptech.glide.request.RequestOptions


class CountryAdapter constructor(
        countryList:MutableList<Country>,
        private val countryAdapterClickListener: CountryAdapterClickListener): BaseAdapter<Country>(countryList, R.layout.item_country
    ){


    override fun View.bind(item: Country, position: Int, holder: Holder) {
        setOnClickListener {
            countryAdapterClickListener.onItemClick(item)
        }
        country_name.text = item.name
        Glide.with(context).load(item.flag).into(country_image)


    }

    interface CountryAdapterClickListener{

        fun onItemClick(country: Country)

    }


}

