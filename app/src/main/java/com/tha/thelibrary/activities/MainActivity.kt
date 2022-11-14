package com.tha.thelibrary.activities


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayout
import com.tha.thelibrary.R
import com.tha.thelibrary.adapters.CarouselAdapter
import com.tha.thelibrary.adapters.ParentRecyclerAdapter
import com.tha.thelibrary.delegates.CarouselDelegate
import com.tha.thelibrary.delegates.ChildRecyclerDelegate
import com.tha.thelibrary.delegates.ParentRecyclerDelegate
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : BaseActivity(), ParentRecyclerDelegate, ChildRecyclerDelegate,
    CarouselDelegate {

    private lateinit var mCarouselAdapter: CarouselAdapter
    private lateinit var mOuterRecyclerAdapter: ParentRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpCarouselViewPager()
        setUpTabLayout()
        setUpParentRecycler()
        setUpTabLayoutListener()
    }

    //Setup Carousel
    private fun setUpCarouselViewPager() {
        mCarouselAdapter = CarouselAdapter(this)
        vpCarousel.adapter = mCarouselAdapter
        vpCarousel.clipToPadding = false
        vpCarousel.clipChildren = false
        vpCarousel.offscreenPageLimit = 5
        vpCarousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        //add some space between the carousel items
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(0))

        //Adding Scaling (Zoom-in) Effect
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.85f + r * 0.15f)
        }
        vpCarousel.setPageTransformer(compositePageTransformer)
    }

    //setup tab layout
    private fun setUpTabLayout() {
        val tabDataList = listOf("Ebooks", "Audiobooks")
        tabDataList.forEach {
            tbBooksGeneric.newTab().apply {
                text = it
                tbBooksGeneric.addTab(this)
            }
        }
    }

    //setup outer recycler view
    private fun setUpParentRecycler() {
        mOuterRecyclerAdapter = ParentRecyclerAdapter(this, this)
        rvParentRecycler.adapter = mOuterRecyclerAdapter
        rvParentRecycler.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun onTapParentRecyclerHeader() {
        startActivity(BooksTypeActivity.newIntent(this))
    }

    //setup tab layout listener
    private fun setUpTabLayoutListener() {
        tbBooksGeneric.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                /*when(tab?.position){
                    0 ->{
                        vpCarousel.setPadding(260,0,260,0)
                    }
                    1->{
                        vpCarousel.setPadding(400,0,400,0)
                    }
                }*/
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }


    override fun onTapCarouselOptionMenu() {
        showBottomSheet(carouselBottomSheet)
    }

    override fun onTapOptionMenu() {
        showBottomSheet(bottomSheet)
    }

}