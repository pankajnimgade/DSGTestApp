package com.test.sdg.dsgtestapp.first.page.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.test.sdg.dsgtestapp.R
import com.test.sdg.dsgtestapp.first.page.model.MainActivityModel
import com.test.sdg.dsgtestapp.first.page.model.Venue
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val presenter = MainActivityPresenter(MainActivityModel())

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.MainActivity_venue_list_RecyclerView)
    }

    override fun onResume() {
        super.onResume()
        presenter.requestData("https://movesync-qa.dcsg.com/dsglabs/mobile/api/venue/")
        presenter.setView(this)
    }


    fun loadInformation(venueList: List<Venue>) {
        val venueAdapter = VenueAdapter(this, venueList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = venueAdapter
        venueAdapter.notifyDataSetChanged()
    }
}


