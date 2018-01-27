package com.test.sdg.dsgtestapp.dsg.app.preferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Pankaj Nimgade on 1/26/2018.
 */
class FavoriteVenuePreference {

    private var sharedPreferences: SharedPreferences
    private var editor: SharedPreferences.Editor


    constructor(context: Context) {
        sharedPreferences = context.getSharedPreferences(VENUE_FILE, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    companion object {
        const val VENUE_ID_KEY = "VENUE_ID_KEY"
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
}