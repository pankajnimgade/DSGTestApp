/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.test.sdg.dsgtestapp.first.page.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
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
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), VenueAdapter.FavoriteVenue {

    private val TAG = "MainActivity"

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @Inject
    lateinit var presenter: MainActivityPresenter

    private lateinit var recyclerView: RecyclerView
    private lateinit var venueAdapter: VenueAdapter
    private lateinit var messageSnackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initializeUI()
    }

    private fun initializeUI() {
        messageSnackbar = Snackbar.make(findViewById(R.id.MainActivity_root_CoordinatorLayout), "",
                Snackbar.LENGTH_SHORT)
        recyclerView = findViewById(R.id.MainActivity_venue_list_RecyclerView)
        (application as StartUp).mainActivityComponent.inject(this)
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

    fun showError(errorMessage: String) {
        messageSnackbar.setText(errorMessage).show()
    }
}