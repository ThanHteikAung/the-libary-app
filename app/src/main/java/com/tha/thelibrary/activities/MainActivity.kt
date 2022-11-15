package com.tha.thelibrary.activities


import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.tha.thelibrary.R
import com.tha.thelibrary.fragments.HomeFragment
import com.tha.thelibrary.fragments.LibraryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swiftFragment(HomeFragment())
        setUpBottomNavigationListener()
    }

    //setup bottomNavigation listener
    private fun setUpBottomNavigationListener() {
        bottomNavigate.setOnItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.homeMenu -> {
                    swiftFragment(HomeFragment())
                }
                R.id.libraryMenu -> {
                    swiftFragment(LibraryFragment())
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
}