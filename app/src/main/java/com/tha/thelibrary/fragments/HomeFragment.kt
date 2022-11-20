package com.tha.thelibrary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayout
import com.tha.thelibrary.R
import com.tha.thelibrary.activities.BooksTypeActivity
import com.tha.thelibrary.adapters.CarouselAdapter
import com.tha.thelibrary.adapters.ParentRecyclerAdapter
import com.tha.thelibrary.data.vos.BooksVO
import com.tha.thelibrary.data.vos.ListVO
import com.tha.thelibrary.mvp.presenters.HomePresenter
import com.tha.thelibrary.mvp.presenters.HomePresenterImpl
import com.tha.thelibrary.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.abs

class HomeFragment : BaseFragment(), HomeView {

    private lateinit var mCarouselAdapter: CarouselAdapter
    private lateinit var mOuterRecyclerAdapter: ParentRecyclerAdapter

    private lateinit var mPresenter: HomePresenter
    private lateinit var mBindData: List<ListVO>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpCarouselViewPager()
        setUpTabLayout()
        setUpParentRecycler()
        setUpTabLayoutListener()

        mPresenter.onUiReady(this)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[HomePresenterImpl::class.java]
        mPresenter.initView(this)
    }

    //Setup Carousel
    private fun setUpCarouselViewPager() {
        mCarouselAdapter = CarouselAdapter(mPresenter)
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
        mOuterRecyclerAdapter = ParentRecyclerAdapter(mPresenter, mPresenter)
        rvParentRecycler.adapter = mOuterRecyclerAdapter
        rvParentRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    //setup tab layout listener
    private fun setUpTabLayoutListener() {
        tbBooksGeneric.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab?.position) {
                    0 -> {
                        vpCarousel.setPadding(260, 0, 260, 0)
                    }
                    1 -> {
                        vpCarousel.setPadding(400, 0, 400, 0)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    override fun bindData(list: List<ListVO>) {
        mBindData = list
        mOuterRecyclerAdapter.setNewData(list)
    }

    override fun showCarouselOptionMenu() {
        context?.let { showBottomSheet(it, R.layout.carousel_menu_book_sheet) }
    }

    override fun showEbooksCategory() {
        startActivity(context?.let { BooksTypeActivity.newIntent(it) })
    }

    override fun showEbooksOptionMenu() {
        context?.let { showBottomSheet(it, R.layout.option_menu_book_sheet) }
    }

    override fun showSaveBooksList(bookList: List<BooksVO>) {
        if (bookList.isNotEmpty()){
            vpCarousel.visibility = View.VISIBLE
            mCarouselAdapter.setNewData(bookList)
        }else{
            vpCarousel.visibility = View.GONE
        }
    }

}