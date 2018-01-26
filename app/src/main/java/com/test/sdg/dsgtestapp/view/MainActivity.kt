package com.test.sdg.dsgtestapp.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.test.sdg.dsgtestapp.R
import com.test.sdg.dsgtestapp.model.MainActivityModel
import com.test.sdg.dsgtestapp.model.Venue
import com.test.sdg.dsgtestapp.presenter.MainActivityPresenter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val presenter = MainActivityPresenter(MainActivityModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.requestData("https://movesync-qa.dcsg.com/dsglabs/mobile/api/venue/")
        presenter.setView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun loadInformation(venueList: List<Venue>) {
        for (single in venueList){
            Log.d(TAG, "id: ${single.id}")
            Log.d(TAG, "name: ${single.name}")
            Log.d(TAG, "canonicalUrl: ${single.canonicalUrl}")
            Log.d(TAG, "verified: ${single.verified}")
            Log.d(TAG, "url: ${single.url}")
            Log.d(TAG, "ratingColor: ${single.ratingColor}")
            Log.d(TAG, "ratingSignals: ${single.ratingSignals}")
            Log.d(TAG, "rating: ${single.rating}")
            Log.d(TAG, "description: ${single.description}")
            Log.d(TAG, "storeId: ${single.storeId}")
            Log.d(TAG, "shortUrl: ${single.shortUrl}")
            Log.d(TAG, "timeZone: ${single.timeZone}")
            Log.d(TAG, "location: ${single.location}")

            for (contact in single.contacts){
                Log.d(TAG, "facebook: ${contact.facebook}")
                Log.d(TAG, "facebookName: ${contact.facebookName}")
                Log.d(TAG, "phone: ${contact.phone}")
                Log.d(TAG, "twitter: ${contact.twitter}")

            }
        }
    }
}
