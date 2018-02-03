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