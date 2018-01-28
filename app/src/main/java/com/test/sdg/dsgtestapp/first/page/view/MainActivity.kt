package com.test.sdg.dsgtestapp.first.page.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.test.sdg.dsgtestapp.R
import com.test.sdg.dsgtestapp.dsg.app.StartUp
import com.test.sdg.dsgtestapp.dsg.app.constants.Constants
import com.test.sdg.dsgtestapp.dsg.app.constants.Constants.Companion.LOCATION_PERMISSION
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Location
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Venue
import com.test.sdg.dsgtestapp.first.page.model.MainActivityModel
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), VenueAdapter.FavoriteVenue {

    private val TAG = "MainActivity"

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private val presenter = MainActivityPresenter(MainActivityModel())

    private lateinit var recyclerView: RecyclerView
    private lateinit var venueAdapter: VenueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initializeUI()
    }

    private fun initializeUI() {
        recyclerView = findViewById(R.id.MainActivity_venue_list_RecyclerView)
        fetchLastKnownLocation()
    }


    private fun fetchLastKnownLocation() {
        val checkLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (checkLocationPermission == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationProviderClient.lastLocation.addOnSuccessListener({ location ->
                if (location != null) {
                    StartUp.setLocation(Location(latitude = location.latitude, longitude = location.longitude))
                }
            })
        } else {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Constants.LOCATION_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLastKnownLocation()
                } else {
                    finish()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.requestData("https://movesync-qa.dcsg.com/dsglabs/mobile/api/venue/")
        presenter.setView(this)
    }


    fun loadInformation(venueList: List<Venue>) {
        venueAdapter = VenueAdapter(this, venueList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = venueAdapter
        venueAdapter.notifyDataSetChanged()
    }

    override fun saveFavoriteVenue(favoriteVenue: Venue?) {
        presenter.saveFavoriteVenue(favoriteVenue)
    }

    override fun removeFavoriteVenue(removeFavoriteVenue: Venue?) {
        presenter.removeFavoriteVenue(removeFavoriteVenue)
    }

    fun notifyListChange() {
        recyclerView.post({ venueAdapter.notifyDataSetChanged() })

    }
}


