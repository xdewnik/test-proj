package com.kulya.dev.testproject.ui.main.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.View
import com.kulya.dev.testproject.R
import com.kulya.dev.testproject.ui.common.BaseActivity
import com.kulya.dev.testproject.ui.country.view.CountryFragment
import com.kulya.dev.testproject.ui.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {


    @Inject
    protected lateinit var mainPresenter: MainPresenter


    private val LAYOUT = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        if (savedInstanceState == null) {
            openSendFragment()
        }


    }

    private fun openSendFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, CountryFragment())
        transaction.addToBackStack("CountryFragment")
        transaction.commit()
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        setTitle(R.string.app_name)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                mainPresenter.handleDrawerOpen()
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                mainPresenter.handleDrawerClose()
            }
        })


    }


    override fun setArrowState() {
        toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
    }

    override fun setHamburgerState() {
        drawerLayout?.let{

            toolbar.setNavigationOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger)

        }


    }

    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> drawerLayout.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()

        }
    }

    override fun getContentView() = LAYOUT
}