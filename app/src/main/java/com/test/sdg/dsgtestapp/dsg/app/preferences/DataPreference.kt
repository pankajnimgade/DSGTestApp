package com.test.sdg.dsgtestapp.dsg.app.preferences

import android.content.Context
import android.content.SharedPreferences
import com.test.sdg.dsgtestapp.dsg.app.model.classes.Location

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 *
 * Used to save and retrieve and save venue and location info. etc...
 */
class DataPreference {

    private var sharedPreferences: SharedPreferences
    private var editor: SharedPreferences.Editor


    constructor(context: Context) {
        sharedPreferences = context.getSharedPreferences(VENUE_FILE, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    companion object {
        const val VENUE_ID_KEY = "VENUE_ID_KEY"
        const val LATITUDE_KEY = "LATITUDE_KEY"
        const val LONGITUDE_KEY = "LONGITUDE_KEY"
        const val VENUE_FILE = "VENUE_FILE.xml"
    }

    fun saveVenueId(venueID: String) {
        with(sharedPreferences.edit()) {
            putString(VENUE_ID_KEY, venueID)
            commit()
        }
    }

    fun getVenueID(): String {
        return sharedPreferences.getString(VENUE_ID_KEY, "")
    }

    fun saveCurrentLocation(location: Location) {
        with(sharedPreferences.edit()) {
            putFloat(LATITUDE_KEY, location.latitude.toFloat()).commit()
            putFloat(LONGITUDE_KEY, location.longitude.toFloat()).commit()
        }
    }

    fun retriveLastKnownLocation(): Location {
        val latitude = sharedPreferences.getFloat(LATITUDE_KEY, 0.0f)
        val longitude = sharedPreferences.getFloat(LONGITUDE_KEY, 0.0f)
        return Location(latitude = latitude.toDouble(), longitude = longitude.toDouble())
    }


}