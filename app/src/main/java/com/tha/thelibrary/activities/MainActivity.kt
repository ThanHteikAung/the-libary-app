package com.tha.thelibrary.activities


import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tha.thelibrary.R
import com.tha.thelibrary.fragments.HomeFragment
import com.tha.thelibrary.fragments.LibraryFragment
import com.tha.thelibrary.mvp.presenters.MainPresenter
import com.tha.thelibrary.mvp.presenters.MainPresenterImpl
import com.tha.thelibrary.mvp.views.MainView
import com.tha.thelibrary.network.dataagents.BookDataAgentImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView {

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        swiftFragment(HomeFragment())
        setUpBottomNavigationListener()

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //setup bottomNavigation listener
    private fun setUpBottomNavigationListener() {
        bottomNavigate.setOnItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.homeMenu -> {
                    mPresenter.onTapBottomNavigation(HomeFragment())
                }
                R.id.libraryMenu -> {
                    mPresenter.onTapBottomNavigation(LibraryFragment())
                }
            }
            true
        }
    }

    private fun swiftFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrameLayout, fragment)
            .commit()
    }

    override fun showFragment(fragment: Fragment) {
        swiftFragment(fragment)
    }

}